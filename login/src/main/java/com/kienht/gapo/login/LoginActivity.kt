package com.kienht.gapo.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
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
}
