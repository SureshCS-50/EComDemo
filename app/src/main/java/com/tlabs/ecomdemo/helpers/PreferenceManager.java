package com.tlabs.ecomdemo.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.tlabs.ecomdemo.utils.Constants;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class PreferenceManager {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public PreferenceManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public boolean isLoggedIn() {
        return mSharedPreferences.getBoolean(Constants.KEY_IS_LOGGED_IN, false);
    }

    public void setIsLoggedIn(boolean isLoggedIn){
        mEditor.putBoolean(Constants.KEY_IS_LOGGED_IN, isLoggedIn).apply();
    }

    public void saveUserEmail(String email){
        mEditor.putString(Constants.KEY_USER_EMAIL, email).apply();
    }

    public String getUserEmail(){
        return mSharedPreferences.getString(Constants.KEY_USER_EMAIL, "");
    }

    public void clearData(){
        mEditor.clear();
        mEditor.apply();
    }

}