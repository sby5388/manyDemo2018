package com.by5388.viewpager;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * @author by5388  on 2018/12/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initData();
        initView();
        loadData();
    }

    /**
     * 布局文件
     *
     * @return 布局文件
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 绑定数据
     */
    protected abstract void loadData();

    /**
     * 初始化布局
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
