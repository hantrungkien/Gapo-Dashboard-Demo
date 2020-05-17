package com.kienht.gapo.dashboard.news_feeds

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.base.BaseFragment
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.NewsFeedsFragmentBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.NewsFeedAdapter
import com.kienht.gapo.dashboard.news_feeds.adapter.OnClickPostItemListener
import com.kienht.gapo.dashboard.news_feeds.decoration.NewsFeedsDecoration
import com.kienht.gapo.dashboard.news_feeds.di.inject
import com.kienht.gapo.dashboard.news_feeds.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feeds.viewmodel.NewsFeedsViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
class NewsFeedsFragment : BaseFragment<NewsFeedsFragmentBinding>(), OnClickPostItemListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val newsFeedViewModel by viewModels<NewsFeedsViewModel> { viewModelFactory }

    private val pool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override val layoutResource: Int
        get() = R.layout.news_feeds_fragment

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
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(NewsFeedsDecoration(requireContext()))
                adapter = NewsFeedAdapter(viewLifecycleOwner, pool, this@NewsFeedsFragment)
            }
        }
    }

    override fun onClickPost(post: NewsFeedViewData, position: Int) {

    }
}