package com.tlabs.ecomdemo.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.tlabs.ecomdemo.R;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout mLytHomeCategorys;
    private ViewPager mBannerViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBannerViews = (ViewPager) findViewById(R.id.viewPagerBanner);
        mLytHomeCategorys = (LinearLayout) findViewById(R.id.lytHomeItems);

        loadCategoryList();
    }

    private void loadCategoryList() {

    }
}
