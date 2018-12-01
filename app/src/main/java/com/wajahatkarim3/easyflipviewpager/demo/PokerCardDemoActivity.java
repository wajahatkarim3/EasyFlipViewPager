package com.wajahatkarim3.easyflipviewpager.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer;

import java.util.ArrayList;

public class PokerCardDemoActivity extends AppCompatActivity {

    ViewPager pokerViewPager;
    private PokerPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_card_demo);

        pokerViewPager = findViewById(R.id.pokerViewPager);
        pagerAdapter = new PokerPagerAdapter(this);
        pokerViewPager.setAdapter(pagerAdapter);

        CardFlipPageTransformer cardFlipPageTransformer = new CardFlipPageTransformer();
        cardFlipPageTransformer.setScalable(false);
        cardFlipPageTransformer.setFlipOrientation(CardFlipPageTransformer.VERTICAL);
        pokerViewPager.setPageTransformer(true, cardFlipPageTransformer);

    }

    public class PokerPagerAdapter extends PagerAdapter
    {
        Context context;
        LayoutInflater mLayoutInflater;
        ArrayList pages = new ArrayList<>();

        public PokerPagerAdapter(Context context) {
            this.context = context;
            mLayoutInflater = LayoutInflater.from(context);

            pages.add(new Object());
            pages.add(new Object());
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // This method should create the page for the given position passed to it as an argument.
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            View rootView = mLayoutInflater.inflate(R.layout.card_image_layout, container, false);
            AppCompatImageView imgCardSide = rootView.findViewById(R.id.imgCardSide);
            imgCardSide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0)
                    {
                        pokerViewPager.setCurrentItem(1, true);
                    }
                    else
                    {
                        pokerViewPager.setCurrentItem(0, true);
                    }
                }
            });
            int[] sides = {R.drawable.poker_card_front, R.drawable.poker_card_back};
            imgCardSide.setImageResource(sides[position]);
            container.addView(rootView);
            return rootView;

        }

        // Removes the page from the container for the given position.
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
