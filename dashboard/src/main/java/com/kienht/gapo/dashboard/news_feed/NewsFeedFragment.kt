package com.kienht.gapo.dashboard.news_feed

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.base.BaseFragment
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.dashboard.databinding.NewsFeedFragmentBinding
import com.kienht.gapo.dashboard.news_feed.di.inject
import com.kienht.gapo.dashboard.news_feed.viewmodel.NewsFeedViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
class NewsFeedFragment : BaseFragment<NewsFeedFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val newsFeedViewModel by viewModels<NewsFeedViewModel> { viewModelFactory }

    override val layoutResource: Int
        get() = R.layout.news_feed_fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = newsFeedViewModel
        }


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