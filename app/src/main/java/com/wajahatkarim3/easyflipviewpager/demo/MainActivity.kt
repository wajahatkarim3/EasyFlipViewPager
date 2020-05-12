package com.wajahatkarim3.easyflipviewpager.demo

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager
    private var mPagerAdapter: PagerAdapter? = null
    lateinit var radioGroupFlipAnimation: RadioGroup
    lateinit var checkEnableScale: CheckBox

    var bookFlipTransformer = BookFlipPageTransformer()
    var cardFlipTransformer = CardFlipPageTransformer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupFlipAnimation = findViewById(R.id.rgFlipAnimation)
        checkEnableScale = findViewById(R.id.checkEnableScale)

        // Book Flip Transformer
        bookFlipTransformer.isEnableScale = true
        bookFlipTransformer.scaleAmountPercent = 10f

        // Card Flip Transformer
        cardFlipTransformer.isScalable = false
        cardFlipTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.pager)
        mPagerAdapter = DemoPagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
        mPager.clipToPadding = false

        updatePagerConfigs()

        radioGroupFlipAnimation.setOnCheckedChangeListener { radioGroup, id ->
            updatePagerConfigs()
        }

        checkEnableScale.setOnCheckedChangeListener { compoundButton, value ->
            updatePagerConfigs()
        }
    }

    fun updatePagerConfigs()
    {
        when(radioGroupFlipAnimation.checkedRadioButtonId)
        {
            R.id.radioBookFlip -> {
                bookFlipTransformer.isEnableScale = checkEnableScale.isChecked
                mPager.setPageTransformer(true, bookFlipTransformer)
            }
            R.id.radioCardFlip -> {
                cardFlipTransformer.isScalable = checkEnableScale.isChecked
                mPager.setPageTransformer(true, cardFlipTransformer)
            }
        }
    }

    class DemoPagerAdapter : FragmentPagerAdapter
    {
        var fragmentsList = arrayListOf<GalleryImageFragment>()

        constructor(fm: FragmentManager) : super(fm)
        {
            val titles = arrayOf(
                    "Book Onboarding",
                    "Poker Card",
                    "Pakistan Gallery",
                    "ViewPager2 Demo"
            )

            val imageIds = intArrayOf(
                    R.drawable.books_snap,
                    R.drawable.poker_snap,
                    R.drawable.gallery_snap,
                    R.drawable.viewpager2_snap
            )

            for (i in 0 until imageIds.size)
            {
                var frag = GalleryImageFragment.newInstance(titles[i], null, imageIds[i])
                fragmentsList.add(frag)
            }
        }

        override fun getItem(position: Int): Fragment = fragmentsList[position]

        override fun getCount() = fragmentsList.size

    }
}
