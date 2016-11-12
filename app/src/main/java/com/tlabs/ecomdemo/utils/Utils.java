package com.tlabs.ecomdemo.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.models.Item;
import com.tlabs.ecomdemo.models.Store;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 09/11/16.
 */

public class Utils {
    public static <T> String convertObjectToStringJson(T someObject, Type type) {
        Gson mGson = new Gson();
        String mStrJson = mGson.toJson(someObject, type);
        return mStrJson;
    }

    public static <T> T getObjectFromJson(String json, Type type) {
        Gson mGson = new Gson();
        if (json != null) {
            if (json.isEmpty()) {
                return null;
            }
        }
        return mGson.fromJson(json, type);
    }

    public static void loadStaticData() {
        List<Category> categories = getObjectFromJson(Constants.JSON_CATEGORIES, new TypeToken<List<Category>>(){}.getType());
        for(Category category : categories){
            category.save();
        }

        List<Store> stores = getObjectFromJson(Constants.JSON_STORES, new TypeToken<List<Store>>(){}.getType());
        for(Store store : stores){
            store.save();
        }

        List<Item> items = new ArrayList<>();
        List<Item> fruits = getObjectFromJson(Constants.JSON_ITEMS_FRUITS, new TypeToken<List<Item>>(){}.getType());
        int[] fItems = {R.drawable.fa, R.drawable.fb, R.drawable.fc, R.drawable.fd, R.drawable.fe, R.drawable.ff, R.drawable.fg};
        for(int i = 0; i < fruits.size(); i++){
            fruits.get(i).drawable = fItems[i];
        }
        List<Item> groceries = getObjectFromJson(Constants.JSON_ITEMS_GROCERY, new TypeToken<List<Item>>(){}.getType());
        int[] gItems = {R.drawable.ga, R.drawable.gb, R.drawable.gc, R.drawable.gd};
        for(int i = 0; i < groceries.size(); i++){
            groceries.get(i).drawable = gItems[i];
        }
        List<Item> breakfasts = getObjectFromJson(Constants.JSON_ITEMS_BREAKFAST, new TypeToken<List<Item>>(){}.getType());
        int[] bdItems = {R.drawable.bdi, R.drawable.bdii, R.drawable.bdiii, R.drawable.bdiv};
        for(int i = 0; i < breakfasts.size(); i++){
            breakfasts.get(i).drawable = bdItems[i];
        }
        List<Item> households = getObjectFromJson(Constants.JSON_ITEMS_HOUSEHOLD_NEEDS, new TypeToken<List<Item>>(){}.getType());
        int[] hdItems = {R.drawable.ha, R.drawable.hb};
        for(int i = 0; i < households.size(); i++){
            households.get(i).drawable = hdItems[i];
        }
        List<Item> personalCares = getObjectFromJson(Constants.JSON_ITEMS_PERSONAL_CARE, new TypeToken<List<Item>>(){}.getType());
        int[] pItems = {R.drawable.pa, R.drawable.pb, R.drawable.pc, R.drawable.pd, R.drawable.pe, R.drawable.pf, R.drawable.pg};
        for(int i = 0; i < personalCares.size(); i++){
            personalCares.get(i).drawable = pItems[i];
        }
        items.addAll(fruits);
        items.addAll(groceries);
        items.addAll(breakfasts);
        items.addAll(households);
        items.addAll(personalCares);

        for(Item item : items){
            item.save();
        }
    }

    public static String displayFractionstoDecimals(String value) {
        try {
            return value.replaceAll("¼", "\\.25").replaceAll("½", "\\.5").replaceAll("¾", "\\.75");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
