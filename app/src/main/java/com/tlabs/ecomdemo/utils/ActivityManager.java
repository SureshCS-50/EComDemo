package com.tlabs.ecomdemo.utils;

import android.app.Activity;
import android.content.Intent;

import com.tlabs.ecomdemo.ui.activities.HomeActivity;
import com.tlabs.ecomdemo.ui.activities.LoginActivity;
import com.tlabs.ecomdemo.ui.activities.SignUpActivity;

/**
 * Created by Sureshkumar on 06/11/16.
 */

public class ActivityManager {

    public static void showLoginActivity(Activity activity){
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    public static void showSignupActivity(Activity activity){
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
    }

    public static void showHomeActivity(Activity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

}
