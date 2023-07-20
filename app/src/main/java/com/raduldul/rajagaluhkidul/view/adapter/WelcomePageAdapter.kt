package com.raduldul.rajagaluhkidul.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.raduldul.rajagaluhkidul.view.*


class WelcomePageAdapter(fragment: Fragment, val listOfPagerContents: List<Array<String>>, val mPageNumbers :Int) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return mPageNumbers
    }

    @Suppress("UNREACHABLE_CODE")
    override fun createFragment(position: Int): Fragment {
        val fragment = Welcome1Fragment()

        when(position){
            0 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[0])
                }
            1 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[1])
                }
            2 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[2])
                }
            3 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[3])
                }
        }
        return fragment
    }
}