package com.kienht.gapo.dashboard.videos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.base.BaseBindingFragment
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.VideosFragmentBinding
import com.kienht.gapo.dashboard.videos.di.inject
import com.kienht.gapo.dashboard.videos.viewmodel.VideosViewModel
import javax.inject.Inject

/**
 * @author kienht
 */
class VideosFragment : BaseBindingFragment<VideosFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val videosViewModel by viewModels<VideosViewModel> { viewModelFactory }

    override val layoutResource: Int
        get() = R.layout.videos_fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = videosViewModel

            buttonPostDetails.setOnClickListener {
                navigateToPostsDetails()
            }
        }
    }

    /**
     * [com.kienht.gapo.post_details.PostDetailsActivity]
     */
    private fun navigateToPostsDetails() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kienht://postdetails/69"))
        startActivity(intent)
    }
}
