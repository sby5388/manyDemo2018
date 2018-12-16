package com.by5388.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.by5388.viewpager.CustomFragment;

import java.util.List;

/**
 * 设配器
 *
 * @author by5388  on 2018/12/16.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;

    public FragmentAdapter(FragmentManager fragmentManager, List<String> titles) {
        super(fragmentManager);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return CustomFragment.newInstance(titles.get(position));
    }

    @Override
    public int getCount() {
        return titles.size();
    }
}
