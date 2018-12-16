package com.by5388.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author by5388  on 2018/12/16.
 */
public abstract class BaseFragment extends Fragment {
    protected FragmentCallBack callBack;

    interface FragmentCallBack {
        /**
         * TODO: 2018/12/16   某个回调，待修改
         * 简单修改一下标题
         *
         * @param title uri
         */
        void setTitleByFragment(String title);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutId(), container, false);
        initView(view);
        loadData();
        return view;
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 布局文件
     *
     * @return 布局文件
     */
    @LayoutRes
    protected abstract int getFragmentLayoutId();

    /**
     * 初始化布局
     *
     * @param view 根布局
     */
    protected abstract void initView(View view);

    /**
     * 绑定数据
     */
    protected abstract void loadData();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallBack) {
            callBack = (FragmentCallBack) context;
        } else {
            throw new RuntimeException("context must implement FragmentCallBack ");
        }
    }
}
