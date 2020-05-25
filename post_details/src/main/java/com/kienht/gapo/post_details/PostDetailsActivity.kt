package com.kienht.gapo.post_details

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.deeplinkdispatch.DeepLink
import com.kienht.gapo.core.base.BaseBindingActivity
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.post_details.adapter.CommentAdapter
import com.kienht.gapo.post_details.databinding.PostDetailsActivityBinding
import com.kienht.gapo.post_details.decoration.CommentDecoration
import com.kienht.gapo.post_details.di.inject
import com.kienht.gapo.post_details.viewmodel.PostDetailsViewModel
import javax.inject.Inject

/**
 * @author kienht
 */
@DeepLink("kienht://postdetails/{id}")
class PostDetailsActivity : BaseBindingActivity<PostDetailsActivityBinding>() {

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
            Log.e(TAG, "onCreate: id = $id")
        }

        with(binding) {
            viewModel = dashboardViewModel

            listComments.apply {
                itemAnimator = null
                layoutManager = LinearLayoutManager(this@PostDetailsActivity)
                addItemDecoration(
                    CommentDecoration(this@PostDetailsActivity)
                )
                setHasFixedSize(true)
                adapter = CommentAdapter(this@PostDetailsActivity)
            }

            buttonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}
