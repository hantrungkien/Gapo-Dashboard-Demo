package com.kienht.gapo.post_details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.airbnb.deeplinkdispatch.DeepLink
import com.kienht.gapo.core.base.BaseActivity
import com.kienht.gapo.post_details.databinding.PostDetailsActivityBinding
import com.kienht.gapo.post_details.di.inject
import com.kienht.gapo.post_details.viewmodel.PostDetailsViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
@DeepLink("kienht://postdetails/{id}")
class PostDetailsActivity : BaseActivity<PostDetailsActivityBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val dashboardViewModel by viewModels<PostDetailsViewModel> { viewModelFactory }

    override val layoutResource: Int
        get() = R.layout.post_details_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val id = intent.extras?.getString("id") ?: throw IllegalArgumentException()
        }

        with(binding) {
            viewModel = dashboardViewModel
        }
    }
}