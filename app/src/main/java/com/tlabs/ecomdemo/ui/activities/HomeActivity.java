package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.adapters.HomeBannerPagerAdapter;
import com.tlabs.ecomdemo.adapters.HomeCategoryAdapter;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.models.UserAccount;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;

import java.util.List;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
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

        UserAccount userAccount = mDataManager.getUserAccountByEmail(mPreferenceManager.getUserEmail());

        mCategories = mDataManager.getAllCategories();

        mBannerHandler = new Handler();
        mBannerPager = (ViewPager) findViewById(R.id.viewPagerBanner);
        mLytHomeCategories = (LinearLayout) findViewById(R.id.lytHomeItems);
        mHomeCategoryAdapter = new HomeCategoryAdapter(this, mCategories);
        mHomeBannerPagerAdapter = new HomeBannerPagerAdapter(getSupportFragmentManager());

        loadBanners();
        loadCategoryList();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView txtName = (TextView) headerView.findViewById(R.id.txtName);
        TextView txtEmail = (TextView) headerView.findViewById(R.id.txtEmail);
        txtName.setText(userAccount.name);
        txtEmail.setText(userAccount.email);
        navigationView.setNavigationItemSelectedListener(this);
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



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            ActivityManager.showCartHistoryActivity(HomeActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_logout) {
            mPreferenceManager.clearData();
            mDataManager.clearData();
            ActivityManager.showLoginActivity(HomeActivity.this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
