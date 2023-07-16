package com.raduldul.rajagaluhkidul.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.raduldul.rajagaluhkidul.view.Welcome1Fragment
import com.raduldul.rajagaluhkidul.view.Welcome2Fragment
import com.raduldul.rajagaluhkidul.view.Welcome3Fragment
import com.raduldul.rajagaluhkidul.view.Welcome4Fragment

class WelcomePageAdapter(fragmentActivity: FragmentActivity, private val viewPager: ViewPager2) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        Welcome1Fragment(),
        Welcome2Fragment(),
        Welcome3Fragment(),
        Welcome4Fragment()

    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    @Suppress("UNREACHABLE_CODE")
    override fun createFragment(position: Int): Fragment {
        val fragment = fragments[position]
        if (fragment is Welcome1Fragment) {
            fragment.onNextButtonClick = {
                val nextPosition = viewPager.currentItem + 1
                if (nextPosition < fragments.size) {
                    viewPager.setCurrentItem(nextPosition, true)
                }
            }
        }
        return fragment
    }
}