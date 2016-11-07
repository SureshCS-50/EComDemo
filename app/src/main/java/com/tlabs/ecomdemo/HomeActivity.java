package com.tlabs.ecomdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private String[] mCategoryItems = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7"};
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
