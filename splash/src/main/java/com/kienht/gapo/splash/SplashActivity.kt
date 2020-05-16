package com.kienht.gapo.splash

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kienht.gapo.core.base.BaseActivity
import com.kienht.gapo.splash.databinding.SplashActivityBinding
import com.kienht.gapo.splash.di.inject
import com.kienht.gapo.splash.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class SplashActivity : BaseActivity<SplashActivityBinding>() {

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
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://login"))
            startActivity(intent)
            finish()
        }
    }
}