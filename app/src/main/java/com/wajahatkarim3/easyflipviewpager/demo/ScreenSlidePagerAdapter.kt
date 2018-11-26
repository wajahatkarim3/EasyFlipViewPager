package com.wajahatkarim3.easyflipviewpager.demo

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val colors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN)
        return MyFragment.newInstance(colors[position], position)
    }

    override fun getCount(): Int {
        return 4
    }
}