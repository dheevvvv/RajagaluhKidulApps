package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentWelcomePageBinding
import com.raduldul.rajagaluhkidul.view.adapter.WelcomePageAdapter



class WelcomePageFragment : Fragment() {
    private lateinit var binding: FragmentWelcomePageBinding
    private val mPageNumbers = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomePageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter =
            WelcomePageAdapter(this,getListOfPagerContents(),mPageNumbers)
        val viewPager = binding.viewPager
        val tabsLayout = binding.tabLayout
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabsLayout, viewPager)
        { tab, position ->}.attach()

        tabsLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.earth_01))
    }

    fun getListOfPagerContents(): List<Array<String>> {

        val ar1 = arrayOf(getString(R.string.intro_title_1), getString(R.string.intro_sub_title_1),"R" )
        val ar2 = arrayOf(getString(R.string.intro_title_2), getString(R.string.intro_sub_title_2) ,"G")
        val ar3 = arrayOf(getString(R.string.intro_title_3), getString(R.string.intro_sub_title_3) ,"B")
        return listOf(ar1,ar2,ar3)
    }

}