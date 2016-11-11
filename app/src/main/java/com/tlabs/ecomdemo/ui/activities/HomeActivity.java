package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.google.gson.reflect.TypeToken;
import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.adapters.HomeBannerPagerAdapter;
import com.tlabs.ecomdemo.adapters.HomeCategoryAdapter;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.Constants;
import com.tlabs.ecomdemo.utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private LinearLayout mLytHomeCategories;
    private ViewPager mBannerPager;
    private List<Category> mCategories;
    private HomeCategoryAdapter mHomeCategoryAdapter;
    private HomeBannerPagerAdapter mHomeBannerPagerAdapter;
    private Handler mBannerHandler;
    private int mDelay = 3000; //milliseconds
    private int mPage = 0;
    Runnable mBannerRunnable = new Runnable() {
        public void run() {
            if (mHomeBannerPagerAdapter.getCount() == mPage) {
                mPage = 0;
            } else {
                mPage++;
            }
            mBannerPager.setCurrentItem(mPage, true);
            mBannerHandler.postDelayed(this, mDelay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mCategories = mDataManager.getAllCategories();

        mBannerHandler = new Handler();
        mBannerPager = (ViewPager) findViewById(R.id.viewPagerBanner);
        mLytHomeCategories = (LinearLayout) findViewById(R.id.lytHomeItems);
        mHomeCategoryAdapter = new HomeCategoryAdapter(this, mCategories);
        mHomeBannerPagerAdapter = new HomeBannerPagerAdapter(getSupportFragmentManager());

        loadBanners();
        loadCategoryList();
    }

    private void loadBanners() {
        mBannerPager.setAdapter(mHomeBannerPagerAdapter);
        mBannerPager.setCurrentItem(0);
        mBannerPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCategoryList() {
        try {
            for (int i = 0; i < mHomeCategoryAdapter.getCount(); i++) {
                mLytHomeCategories.addView(mHomeCategoryAdapter.getView(i, null, null));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBannerHandler.removeCallbacks(mBannerRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBannerHandler.postDelayed(mBannerRunnable, mDelay);
    }
}
