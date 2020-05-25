package com.kienht.gapo.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kienht.gapo.core.utils.bundleOf

/**
 * @author kienht
 * Được sử dụng để làm RootFragment cho từng StackFragment
 */
class DashboardNavHostFragment private constructor() : Fragment() {

    companion object {
        private const val LAYOUT_ARG = "LAYOUT_ARG"
        private const val NAV_HOST_ARG = "NAV_HOST_ARG"

        fun newInstance(layoutRes: Int, navHostId: Int) =
            DashboardNavHostFragment().apply {
                arguments = bundleOf(
                    LAYOUT_ARG to layoutRes,
                    NAV_HOST_ARG to navHostId
                )
            }
    }

    private val layoutRes by lazy {
        requireArguments().getInt(LAYOUT_ARG)
    }

    private val navHostId by lazy {
        requireArguments().getInt(NAV_HOST_ARG)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutRes, container, false)

    fun popToRoot(): Boolean {
        val navController = requireActivity().findNavController(navHostId)
        return navController.popBackStack(navController.graph.startDestination, false)
    }

    /**
     * Kiểm tra xem Stack Fragment hiện tại còn có thể BackPressed hay không?
     */
    fun onBackPressed(): Boolean = requireActivity()
        .findNavController(navHostId)
        .navigateUp()

    /**
     * Handle DeepLink to Child Fragment in Stack Fragment
     */
    fun handleDeepLink(intent: Intent) =
        requireActivity().findNavController(navHostId).handleDeepLink(intent)
}
