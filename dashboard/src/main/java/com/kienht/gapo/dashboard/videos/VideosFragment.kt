package com.kienht.gapo.dashboard.videos

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.base.BaseFragment
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.VideosFragmentBinding
import com.kienht.gapo.dashboard.videos.di.inject
import com.kienht.gapo.dashboard.videos.viewmodel.VideosViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class VideosFragment : BaseFragment<VideosFragmentBinding>() {

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
        }

        Log.e(TAG, "onViewCreated")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e(TAG, "onHiddenChanged")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView")
    }
}