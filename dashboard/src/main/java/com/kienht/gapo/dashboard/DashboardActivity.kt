package com.kienht.gapo.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.SparseIntArray
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kienht.gapo.core.base.BaseBindingActivity
import com.kienht.gapo.dashboard.databinding.DashboardActivityBinding
import com.kienht.gapo.dashboard.di.inject
import com.kienht.gapo.dashboard.viewmodel.DashboardViewModel
import java.util.Stack
import javax.inject.Inject

/**
 * @author kienht
 */
@DeepLink("kienht://dashboard")
class DashboardActivity : BaseBindingActivity<DashboardActivityBinding>(),
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val dashboardViewModel by viewModels<DashboardViewModel> { viewModelFactory }

    /**
     * Dùng để lưu các lượt đi qua BottomNavigation Menu Item
     */
    private val backStack = Stack<Int>()

    /**
     * Dùng để lưu các Root Fragment
     */
    private val hostFragments = mutableListOf<DashboardNavHostFragment>()

    /**
     * Index of each BottomNavigation MenuItem
     */
    private val indexToRootPage by lazy {
        SparseIntArray()
            .apply {
                put(0, R.id.news_feed)
                put(1, R.id.videos)
                put(2, R.id.menu)
            }
    }

    private val onPageChanged = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            val itemId = indexToRootPage[position]
            if (bottomNavigation.selectedItemId != itemId)
                bottomNavigation.selectedItemId = itemId
        }
    }

    override val layoutResource: Int
        get() = R.layout.dashboard_activity

    private val viewPager: ViewPager2
        get() = binding.mainPager

    private val bottomNavigation: BottomNavigationView
        get() = binding.bottomNavigation

    private val currentIndexOfViewPager: Int
        get() = viewPager.currentItem

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        viewPager.post {
            checkDeepLink(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        hostFragments.add(
            DashboardNavHostFragment.newInstance(
                R.layout.dashboard_news_feed_host_fragment,
                R.id.nav_host_news_feed
            )
        )
        hostFragments.add(
            DashboardNavHostFragment.newInstance(
                R.layout.dashboard_videos_host_fragment,
                R.id.nav_host_videos
            )
        )
        hostFragments.add(
            DashboardNavHostFragment.newInstance(
                R.layout.dashboard_menu_host_fragment,
                R.id.nav_host_menu
            )
        )

        with(binding) {
            viewModel = dashboardViewModel

            bottomNavigation.setOnNavigationItemSelectedListener(this@DashboardActivity)
            bottomNavigation.setOnNavigationItemReselectedListener(this@DashboardActivity)

            mainPager.isUserInputEnabled = false
            mainPager.offscreenPageLimit = hostFragments.size
            mainPager.adapter = DashboardPagerAdapter(this@DashboardActivity, hostFragments)
            mainPager.registerOnPageChangeCallback(onPageChanged)

            mainPager.post {
                checkDeepLink(intent)
            }
        }

        if (backStack.empty()) backStack.push(0)
    }

    /**
     * Kiểm tra xem Stack Fragment hiện tại còn có thể BackPressed hay không?
     */
    override fun onBackPressed() {
        val fragment = hostFragments[currentIndexOfViewPager]
        val hadNestedFragments = fragment.onBackPressed()
        if (!hadNestedFragments) {
            if (backStack.size > 1) {
                backStack.pop()
                viewPager.setCurrentItem(backStack.peek(), false)
            } else super.onBackPressed()
        }
    }

    /**
     * Nếu Reselected Menu Item sẽ trở về Root Fragment
     */
    override fun onNavigationItemReselected(item: MenuItem) {
        val position = indexToRootPage.indexOfValue(item.itemId)
        val fragment = hostFragments[position]
        fragment.popToRoot()
    }

    /**
     * Chuyển đến Root Fragment tương ứng với MenuItem
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = indexToRootPage.indexOfValue(item.itemId)
        if (currentIndexOfViewPager != position) setItem(position)
        return true
    }

    private fun setItem(position: Int) {
        viewPager.setCurrentItem(position, false)
        backStack.push(position)
    }

    /**
     * Handle DeepLink to Child Fragment in Stack Fragment
     */
    private fun checkDeepLink(intent: Intent) {
        hostFragments.forEachIndexed { index, fragment ->
            val hasDeepLink = fragment.handleDeepLink(intent)
            if (hasDeepLink) setItem(index)
        }
    }
}

internal class DashboardPagerAdapter(
    activity: DashboardActivity,
    private val hostFragments: List<DashboardNavHostFragment>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = hostFragments.size

    override fun createFragment(position: Int): Fragment = hostFragments[position]
}
