package com.tlabs.ecomdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.tlabs.ecomdemo.ui.fragments.HomeBannerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 08/11/16.
 */

public class HomeBannerPagerAdapter extends FragmentStatePagerAdapter {

    int[] mColors = new int[]{0xb0e76868, 0xb0faa860, 0xB0A3FA60};
    private List<Fragment> mBanners;

    public HomeBannerPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mBanners = new ArrayList<>();
        for(int i = 0; i < mColors.length; i++){
            HomeBannerFragment bannerFragment = HomeBannerFragment.newInstance(mColors[i]);
            mBanners.add(bannerFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mBanners.get(position);
    }

    @Override
    public int getCount() {
        return mBanners.size();
    }

}
