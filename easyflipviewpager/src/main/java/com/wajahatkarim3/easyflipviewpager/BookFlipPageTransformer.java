package com.wajahatkarim3.easyflipviewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * A book based page flip animation PageTransformer implementation for ViewPager
 *
 * Set the object of this transformer to any ViewPager object.
 * For example, myViewPager.setPageTransformer(true, new BookFlipPageTransformer());
 *
 * @see <a href="http://github.com/wajahatkarim3/EasyFlipViewPager">EasyFlipViewPager</a>
 *
 * @author Wajahat Karim (http://wajahatkarim.com)
 */
public class BookFlipPageTransformer implements ViewPager.PageTransformer {

    private final int LEFT = -1;
    private final int RIGHT = 1;
    private final int CENTER = 0;

    @Override
    public void transformPage(@NonNull View page, float position) {
        float percentage = 1 - Math.abs(position);
        // Don't move pages once they are on left or right
        if (position > CENTER && position <= RIGHT)
        {
            // This is behind page
            page.setVisibility(View.VISIBLE);
            page.setTranslationX(-position * (page.getWidth()));
            page.setTranslationY(0);
            page.setRotation(0);
        }
        // Otherwise flip the current page
        else
        {
            flipPage(page, position, percentage);
        }
    }

    private void flipPage(View page, float position, float percentage)
    {
        // Flip this page
        page.setCameraDistance(-12000);
        setVisibility(page, position);
        setTranslation(page);
        setPivot(page, 0f, page.getHeight() * 0.5f);
        setRotation(page, position, percentage);
    }

    private void setPivot(View page, float pivotX, float pivotY)
    {
        page.setPivotX(pivotX);
        page.setPivotY(pivotY);
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
}
