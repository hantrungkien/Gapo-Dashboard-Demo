package com.kienht.gapo.dashboard.menu

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.base.BaseBindingFragment
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.MenuFragmentBinding
import com.kienht.gapo.dashboard.menu.adapter.loadmore.LoadmoreAdapter
import com.kienht.gapo.dashboard.menu.adapter.notification.NotificationAdapter
import com.kienht.gapo.dashboard.menu.di.inject
import com.kienht.gapo.dashboard.menu.viewmodel.MenuViewModel
import javax.inject.Inject

/**
 * @author kienht
 */
class MenuFragment : BaseBindingFragment<MenuFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val menuViewModel by viewModels<MenuViewModel> { viewModelFactory }

    private val loadmoreAdapter by lazy { LoadmoreAdapter(viewLifecycleOwner) }
    private val notificationAdapter by lazy { NotificationAdapter(viewLifecycleOwner) }
    private val mergeAdapter by lazy { MergeAdapter(notificationAdapter, loadmoreAdapter) }

    override val layoutResource: Int
        get() = R.layout.menu_fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = menuViewModel

            listNotification.apply {
                adapter = mergeAdapter
                layoutManager = LinearLayoutManager(context)

                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        if (!canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                            loadmoreAdapter.loading = true
                            postDelayed(
                                {
                                    loadmoreAdapter.loading = false
                                },
                                3000
                            )
                        }
                    }
                })
            }
        }

        onViewModel()
    }

    private fun onViewModel() {
        menuViewModel.newsFeedsLiveData.observe(viewLifecycleOwner, Observer {
            notificationAdapter.submitList(it[0].stories)
        })
    }
}