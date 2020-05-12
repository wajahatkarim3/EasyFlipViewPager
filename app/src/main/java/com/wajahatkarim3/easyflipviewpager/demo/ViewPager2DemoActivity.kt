package com.wajahatkarim3.easyflipviewpager.demo

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer2
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer2

class ViewPager2DemoActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var rgOrientation: RadioGroup
    val itemsList = arrayListOf<Int>()
    var sliderAdapter = ScreenSlideRecyclerAdapter(itemsList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_2_demo)

        setupViews()
    }

    fun setupViews()
    {
        // Items
        val colors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN)
        sliderAdapter.setItems(colors.toList())

        // ViewPager
        viewPager = findViewById(R.id.viewPager2)
        viewPager.adapter = sliderAdapter

        var bookTransformer = BookFlipPageTransformer2()
        viewPager.setPageTransformer(bookTransformer)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // RadioGroup
        rgOrientation = findViewById(R.id.rgOrientation)
        rgOrientation.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioHorizontal)
                viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            else
                viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        }
    }
}