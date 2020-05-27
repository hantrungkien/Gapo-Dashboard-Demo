package com.kienht.gapo.login

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.airbnb.deeplinkdispatch.DeepLink
import com.kienht.gapo.core.base.BaseBindingActivity
import com.kienht.gapo.core.common.DataState
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.login.databinding.LoginActivityBinding
import com.kienht.gapo.login.di.inject
import com.kienht.gapo.login.viewmodel.LoginViewModel
import javax.inject.Inject

/**
 * @author kienht
 */
@DeepLink("kienht://login")
class LoginActivity : BaseBindingActivity<LoginActivityBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val loginViewModel by viewModels<LoginViewModel> { viewModelFactory }

    override val layoutResource: Int
        get() = R.layout.login_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        with(binding) {
            viewModel = loginViewModel
        }

        loginViewModel.loginStateLiveData
            .observe(this, Observer {
                when (it) {
                    is DataState.COMPLETE -> {
                        navigateDashboard()
                        createNotification() // test case 1
//                        createNotification2() // test case 2
                    }
                    is DataState.ERROR -> {
                        Log.e(TAG, "loginError: ", it.throwable)
                    }
                }
            })
    }

    /**
     * navigate to [com.kienht.gapo.dashboard.DashboardActivity]
     */
    private fun navigateDashboard() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://dashboard"))
        startActivity(intent)
        finish()
    }

    /**
     * Demo use deeplink to open dashboard from notification:
     * 1. Ấn vào noti sẽ vào dashboard activity, ở tab thứ 2 của bottomNavigation, xong link vào 1 fragment nữa
     * noti -> dashboard -> tab 2(video graph) -> detail(ví dụ là menu fragment)
     */
    private fun createNotification() {

        // create intent navigation
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vit://test/1"))
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        // create noti
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "getString(R.string.channel_name)"
            val descriptionText = "getString(R.string.channel_description)"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.authentication_image)
            .setContentTitle("Login Success")
            .setContentText("Open Dashboard Screen")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this@LoginActivity)) {
            notify(0, builder.build())
        }
    }

    /**
     * Demo use deeplink to open dashboard from notification:
     * 2. Ấn vào noti sẽ vào dashboard activity và 1 activity details nữa sử dụng TaskStackBuilder
     * noti -> postdetails --back--> dashboard
     */
    private fun createNotification2() {

        // create intent navigation
        val postDetailIntent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://postdetails/1"))
        val dashboardIntent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://dashboard"))

        val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntent(dashboardIntent)
            addNextIntent(postDetailIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        // create noti
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "getString(R.string.channel_name)"
            val descriptionText = "getString(R.string.channel_description)"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.authentication_image)
            .setContentTitle("Login Success")
            .setContentText("Open Post Detail Screen")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(resultPendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this@LoginActivity)) {
            notify(0, builder.build())
        }
    }
}