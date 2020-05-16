package com.kienht.gapo.dashboard.menu

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.base.BaseFragment
import com.kienht.gapo.core.utils.TAG
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.MenuFragmentBinding
import com.kienht.gapo.dashboard.menu.di.inject
import com.kienht.gapo.dashboard.menu.viewmodel.MenuViewModel
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class MenuFragment : BaseFragment<MenuFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val menuViewModel by viewModels<MenuViewModel> { viewModelFactory }

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