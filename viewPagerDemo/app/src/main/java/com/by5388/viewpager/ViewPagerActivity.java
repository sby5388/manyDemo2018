package com.by5388.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ViewPager without Fragment
 *
 * @author by5388  on 2018/12/16.
 */
public class ViewPagerActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<View> imageViews;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void initData() {
        List<Integer> imageIds = Arrays.asList(
                R.drawable.ic_1,
                R.drawable.ic_2,
                R.drawable.ic_3,
                R.drawable.ic_4,
                R.drawable.ic_5,
                R.drawable.ic_6
        );
        imageViews = new ArrayList<>();
        ViewGroup rootView = new LinearLayout(this);
        for (Integer imageId : imageIds) {
            ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.image_view, rootView, false);
            imageView.setImageResource(imageId);
            imageViews.add(imageView);
        }
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.view_pager_image);
    }


    @Override
    protected void loadData() {
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                if (o instanceof View) {
                    return o == view;
                } else {
                    return false;
                }
            }


            @NonNull
            @Override
            public View instantiateItem(@NonNull ViewGroup container, int position) {
                View view = imageViews.get(position);
                container.addView(view, 0);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(imageViews.get(position));
            }

        });
    }


    @SuppressWarnings("all")
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ViewPagerActivity.class);
        return intent;
    }
}
