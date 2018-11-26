package com.wajahatkarim3.easyflipviewpager.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer

class BookOnboardingActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager
    private var mPagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_onboarding)

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById<ViewPager>(R.id.pager)
        mPagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
        mPager.clipToPadding = true
        mPager.setPageTransformer(true, BookFlipPageTransformer())
    }
}
