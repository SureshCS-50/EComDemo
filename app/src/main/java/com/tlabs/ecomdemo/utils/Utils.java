package com.tlabs.ecomdemo.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
        List<Item> groceries = getObjectFromJson(Constants.JSON_ITEMS_GROCERY, new TypeToken<List<Item>>(){}.getType());
        List<Item> breakfasts = getObjectFromJson(Constants.JSON_ITEMS_BREAKFAST, new TypeToken<List<Item>>(){}.getType());
        List<Item> households = getObjectFromJson(Constants.JSON_ITEMS_HOUSEHOLD_NEEDS, new TypeToken<List<Item>>(){}.getType());
        List<Item> personalCares = getObjectFromJson(Constants.JSON_ITEMS_PERSONAL_CARE, new TypeToken<List<Item>>(){}.getType());
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
