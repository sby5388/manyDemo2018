package com.by5388.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author by5388  on 2018/12/16.
 */
public class CustomFragment extends BaseFragment {

    public static final String KEY_STRING_TITLE = "CustomFragment_title";
    public static final String KEY_STRING_BUNDLE = "CustomFragment_bundle";
    private String title = "null";
    private TextView textView;

    @SuppressWarnings("all")
    private CustomFragment() {

    }

    @SuppressWarnings("all")
    public static CustomFragment newInstance(String title) {
        CustomFragment fragment = new CustomFragment();
        Bundle argument = new Bundle();
        argument.putString(KEY_STRING_TITLE, title);
        fragment.setArguments(argument);
        return fragment;
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(KEY_STRING_TITLE, title);
        }
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragement_simple_title;
    }

    @Override
    protected void initView(View view) {
        textView = view.findViewById(R.id.textView_title);
    }

    @Override
    protected void loadData() {
        textView.setText(title);
        // TODO: 2018/12/16 设置标题出了点问题
       // callBack.setTitleByFragment(title);
    }
}
