package com.by5388.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.by5388.viewpager.adapter.FragmentAdapter;

import java.util.Arrays;

/**
 * ViewPager with Fragments
 *
 * @author by5388  on 2018/12/16.
 */
public class ViewPagerFragmentActivity extends BaseActivity implements CustomFragment.FragmentCallBack {

    private ViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager_fragment;
    }

    @Override
    protected void initData() {
        String[] titles = getResources().getStringArray(R.array.array_titles);
        adapter = new FragmentAdapter(getSupportFragmentManager(), Arrays.asList(titles));
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.view_pager);
    }

    @Override
    protected void loadData() {
        viewPager.setAdapter(adapter);
    }


    @SuppressWarnings("all")
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ViewPagerFragmentActivity.class);
        return intent;
    }

    @Override
    public void setTitleByFragment(String title) {
        setTitle(title);
    }
}
