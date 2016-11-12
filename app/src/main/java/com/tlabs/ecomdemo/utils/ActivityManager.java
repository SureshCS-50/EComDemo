package com.tlabs.ecomdemo.utils;

import android.app.Activity;
import android.content.Intent;

import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.models.Store;
import com.tlabs.ecomdemo.ui.activities.AddressActivity;
import com.tlabs.ecomdemo.ui.activities.CartActivity;
import com.tlabs.ecomdemo.ui.activities.ItemsActivity;
import com.tlabs.ecomdemo.ui.activities.PaymentActivity;
import com.tlabs.ecomdemo.ui.activities.StoresActivity;
import com.tlabs.ecomdemo.ui.activities.HomeActivity;
import com.tlabs.ecomdemo.ui.activities.LoginActivity;
import com.tlabs.ecomdemo.ui.activities.SignUpActivity;

/**
 * Created by Sureshkumar on 06/11/16.
 */

public class ActivityManager {

    public static void showLoginActivity(Activity activity){
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.finishAffinity();
        activity.startActivity(intent);
    }

    public static void showSignupActivity(Activity activity){
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
    }

    public static void showHomeActivity(Activity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.finishAffinity();
        activity.startActivity(intent);
    }

    public static void showStoresActivity(Activity activity, String categoryId) {
        Intent intent = new Intent(activity, StoresActivity.class);
        intent.putExtra(Constants.KEY_CATEGORY_ID, categoryId);
        activity.startActivity(intent);
    }

    public static void showItemsActivity(Activity activity, String categoryId, String storeId) {
        Intent intent = new Intent(activity, ItemsActivity.class);
        intent.putExtra(Constants.KEY_CATEGORY_ID, categoryId);
        intent.putExtra(Constants.KEY_STORE_ID, storeId);
        activity.startActivity(intent);
    }

    public static void showCartActivity(Activity activity, Long orderId) {
        Intent intent = new Intent(activity, CartActivity.class);
        intent.putExtra(Constants.KEY_ORDER_ID, orderId);
        activity.startActivity(intent);
    }


    public static void showAddressActivity(Activity activity) {
        Intent intent = new Intent(activity, AddressActivity.class);
        activity.startActivity(intent);
    }

    public static void showPaymentActivity(Activity activity) {
        Intent intent = new Intent(activity, PaymentActivity.class);
        activity.startActivity(intent);
    }
}