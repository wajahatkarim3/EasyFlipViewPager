package com.wajahatkarim3.easyflipviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * A card based page flip animation PageTransformer implementation for ViewPager
 *
 * Set the object of this transformer to any ViewPager object.
 * For example, myViewPager.setPageTransformer(true, new CardFlipPageTransformer());
 *
 * @see <a href="http://github.com/wajahatkarim3/EasyFlipViewPager">EasyFlipViewPager</a>
 *
 * @author Wajahat Karim (http://wajahatkarim.com)
 */
public class CardFlipPageTransformer implements ViewPager.PageTransformer {

    private boolean scalable = true;

    public CardFlipPageTransformer(boolean enableScaling)
    {
        scalable = enableScaling;
    }

    @Override
    public void transformPage(View page, float position) {
        float percentage = 1 - Math.abs(position);
        page.setCameraDistance(12000);
        setVisibility(page, position);
        setTranslation(page);
        setSize(page, position, percentage);
        setRotation(page, position, percentage);
    }

    private void setVisibility(View page, float position) {
        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE);
        } else {
            page.setVisibility(View.INVISIBLE);
        }
    }

    private void setTranslation(View page) {
        ViewPager viewPager = (ViewPager) page.getParent();
        int scroll = viewPager.getScrollX() - page.getLeft();
        page.setTranslationX(scroll);
    }

    private void setSize(View page, float position, float percentage) {
        // Do nothing, if its not scalable
        if (!scalable) return;

        page.setScaleX((position != 0 && position != 1) ? percentage : 1);
        page.setScaleY((position != 0 && position != 1) ? percentage : 1);
    }

    private void setRotation(View page, float position, float percentage) {
        if (position > 0) {
            page.setRotationY(-180 * (percentage + 1));
        } else {
            page.setRotationY(180 * (percentage + 1));
        }
    }

    public boolean isScalable() {
        return scalable;
    }

    public void setScalable(boolean scalable) {
        this.scalable = scalable;
    }
}
