package com.tlabs.ecomdemo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tlabs.ecomdemo.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link HomeBannerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeBannerFragment extends Fragment {

    private static final String BANNER_COLOR = "banner_color";
    private ImageView mImgBanner;
    private int mColor;

    public HomeBannerFragment() {
        // Required empty public constructor
    }

    public static HomeBannerFragment newInstance(int color) {
        HomeBannerFragment fragment = new HomeBannerFragment();
        Bundle args = new Bundle();
        args.putInt(BANNER_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColor = getArguments().getInt(BANNER_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home_banner, container, false);
        mImgBanner = (ImageView) view.findViewById(R.id.imgHomeBanner);
        mImgBanner.setImageResource(mColor);
        return view;
    }

}
