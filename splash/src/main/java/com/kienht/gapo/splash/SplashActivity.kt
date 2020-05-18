package com.kienht.gapo.splash

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kienht.gapo.core.base.BaseBindingActivity
import com.kienht.gapo.splash.databinding.SplashActivityBinding
import com.kienht.gapo.splash.di.inject
import com.kienht.gapo.splash.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author kienht
 * Trong demo, SplashActivity được đặt riêng ở 1 module Android Lib bởi vì:
 * 1. Demo cấu hình Dagger cho cả 2 kiểu module Android Lib và Dynamic Feature.
 * 2. Module Lib hữu dụng trong trường hợp phải sử dụng [flavor]Implementation trong gradle nếu app có nhiều [flavors].
 */
class SplashActivity : BaseBindingActivity<SplashActivityBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val splashViewModel by viewModels<SplashViewModel> { viewModelFactory }

    override val layoutResource: Int
        get() = R.layout.splash_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        with(binding) {
            viewModel = splashViewModel
        }

        lifecycleScope.launch {
            delay(2000)
            navigateToLogin()
        }
    }

    /**
     * navigate to [com.kienht.gapo.login.LoginActivity]
     */
    private fun navigateToLogin() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://login"))
        startActivity(intent)
        finish()
    }
}