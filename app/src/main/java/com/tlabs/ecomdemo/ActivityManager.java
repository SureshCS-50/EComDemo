package com.tlabs.ecomdemo;

import android.app.Activity;
import android.content.Intent;

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
