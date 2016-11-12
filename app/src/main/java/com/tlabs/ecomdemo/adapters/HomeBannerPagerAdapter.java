package com.tlabs.ecomdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.ui.fragments.HomeBannerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 08/11/16.
 */

public class HomeBannerPagerAdapter extends FragmentStatePagerAdapter {

    int[] mImgaes = new int[]{R.drawable.banner_o, R.drawable.banner_t, R.drawable.banner_th};
    private List<Fragment> mBanners;

    public HomeBannerPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mBanners = new ArrayList<>();
        for(int i = 0; i < mImgaes.length; i++){
            HomeBannerFragment bannerFragment = HomeBannerFragment.newInstance(mImgaes[i]);
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
