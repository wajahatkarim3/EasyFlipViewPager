/*
Copyright 2018 Wajahat Karim

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.wajahatkarim3.easyflipviewpager;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

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
    private float scaleAmountPercent = 5f;
    private boolean enableScale = true;

    @Override
    public void transformPage(@NonNull View page, float position) {
        float percentage = 1 - Math.abs(position);
        // Don't move pages once they are on left or right
        if (position > CENTER && position <= RIGHT)
        {
            // This is behind page
            page.setTranslationX(-position * (page.getWidth()));
            page.setTranslationY(0);
            page.setRotation(0);
            if (enableScale)
            {
                float amount = ((100 - scaleAmountPercent) + ( scaleAmountPercent * percentage)) / 100;
                setSize(page, position, amount);
            }
        }
        // Otherwise flip the current page
        else
        {
            page.setVisibility(View.VISIBLE);
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

    public float getScaleAmountPercent() {
        return scaleAmountPercent;
    }

    public void setScaleAmountPercent(float scaleAmountPercent) {
        this.scaleAmountPercent = scaleAmountPercent;
    }

    public boolean isEnableScale() {
        return enableScale;
    }

    public void setEnableScale(boolean enableScale) {
        this.enableScale = enableScale;
    }
}
