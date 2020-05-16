package com.kienht.gapo.dashboard.news_feed

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.base.BaseFragment
import com.kienht.gapo.core.common.DataState
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.dashboard.databinding.NewsFeedFragmentBinding
import com.kienht.gapo.dashboard.news_feed.adapter.NewsFeedAdapter
import com.kienht.gapo.dashboard.news_feed.adapter.OnClickPostItemListener
import com.kienht.gapo.dashboard.news_feed.decoration.NewsFeedDecoration
import com.kienht.gapo.dashboard.news_feed.di.inject
import com.kienht.gapo.dashboard.news_feed.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feed.viewmodel.NewsFeedViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
class NewsFeedFragment : BaseFragment<NewsFeedFragmentBinding>(), OnClickPostItemListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val newsFeedViewModel by viewModels<NewsFeedViewModel> { viewModelFactory }

    private val pool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

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

            listPost.apply {
                itemAnimator = null
                setHasFixedSize(true)//only for demo
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(NewsFeedDecoration(requireContext()))
                adapter = NewsFeedAdapter(viewLifecycleOwner, pool, this@NewsFeedFragment)
            }
        }

        newsFeedViewModel.dataState
            .observe(viewLifecycleOwner, Observer {
                when (it) {
                    is DataState.SUCCESS<List<NewsFeedViewData>> -> {
                        Log.e(TAG, "SUCCESS: ${it.data.size}")
                    }
                    is DataState.ERROR -> {
                        Log.e(TAG, "ERROR: ", it.throwable)
                    }
                }
            })
        newsFeedViewModel.fetch()
    }

    override fun onClickPost(post: NewsFeedViewData, position: Int) {

    }
}