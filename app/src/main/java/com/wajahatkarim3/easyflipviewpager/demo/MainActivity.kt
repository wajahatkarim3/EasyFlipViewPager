package com.wajahatkarim3.easyflipviewpager.demo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager
    private var mPagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById<ViewPager>(R.id.pager)
        mPagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
        mPager.clipToPadding = false
        var transformer = CardFlipPageTransformer()
        transformer.flipOrientation = CardFlipPageTransformer.HORIZONTAL
        transformer.isScalable = true
        mPager.setPageTransformer(true, transformer)
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val colors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN)
            return MyFragment.newInstance(colors[position], position)
        }

        override fun getCount(): Int {
            return 4
        }
    }
}
