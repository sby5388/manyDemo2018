package com.by5388.viewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * ViewPagerDemo
 *
 * @author by5388  on 2018/12/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.button_fragment).setOnClickListener(v ->
                startActivity(ViewPagerFragmentActivity.newIntent(this))
        );
        findViewById(R.id.button_viewPager).setOnClickListener(v ->
                startActivity(ViewPagerActivity.newIntent(this))
        );
    }


}
