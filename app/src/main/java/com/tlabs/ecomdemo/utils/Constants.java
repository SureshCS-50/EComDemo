package com.tlabs.ecomdemo.utils;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class Constants {
    public static final String PREFERENCE_NAME = "e_com_preference_manager";

    // constants..
    public static final String JSON_CATEGORIES = "[{\"categoryId\":1,\"name\":\"Fruits & Vegetables\",\"drawable\":\"fruits\",\"description\":\"Fruit & Vegetable Baskets, Cut Frush, Sprouts & Herbs\"},{\"categoryId\":2,\"name\":\"Grocery & Staples\",\"drawable\":\"grocery\",\"description\":\"Rice & Flour, Edible Oils & Ghee, Pulses, Spices, Salt & Sugar, Dry Fruits & Nuts\"},{\"categoryId\":3,\"name\":\"Household Needs\",\"drawable\":\"households\",\"description\":\"Laundry Detergents, Dishwashers & Cleaners, Repellents and Fresheners\"},{\"categoryId\":4,\"name\":\"Personal Care\",\"drawable\":\"personal_care\",\"description\":\"Body & Face Care, Hair Care, Oral Care, Grooming Needs, Cosmetics, Fragrances\"},{\"categoryId\":5,\"name\":\"Breakfast & Dairy\",\"drawable\":\"breakfast\",\"description\":\"Milk & Milk Products, Paneer & Curd, Butter & Cheese, Bread & Eggs\"}]";
    public static final String JSON_STORES = "[{\"storeId\":1,\"name\":\"Herbals\",\"drawable\":\"0\",\"rating\":\"5.0\",\"locality\":\"Guindy\",\"city\":\"Chennai\"},{\"storeId\":2,\"name\":\"Big market\",\"drawable\":\"0\",\"rating\":\"4.0\",\"locality\":\"Guindy\",\"city\":\"Chennai\"},{\"storeId\":3,\"name\":\"Big Bazaar\",\"drawable\":\"0\",\"rating\":\"4.8\",\"locality\":\"Alandur\",\"city\":\"Chennai\"},{\"storeId\":4,\"name\":\"Naturals\",\"drawable\":\"0\",\"rating\":\"4.9\",\"locality\":\"Ashok Nagar\",\"city\":\"Chennai\"},{\"storeId\":5,\"name\":\"Star Bazaar\",\"drawable\":\"0\",\"rating\":\"5.0\",\"locality\":\"Royapettah\",\"city\":\"Chennai\"}]";
    public static final String JSON_ITEMS_FRUITS = "[{\"itemId\":1,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Lady Finger\",\"drawable\":\"\",\"quantity\":\"50gm\",\"price\":7},{\"itemId\":2,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Green Chilli\",\"drawable\":\"\",\"quantity\":\"100gm\",\"price\":5},{\"itemId\":3,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Green Capsicum\",\"drawable\":\"\",\"quantity\":\"100gm\",\"price\":12},{\"itemId\":4,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Lemon\",\"drawable\":\"\",\"quantity\":\"250gm\",\"price\":10},{\"itemId\":5,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Beetroot\",\"drawable\":\"\",\"quantity\":\"1 kg\",\"price\":50}]";
    public static final String JSON_ITEMS_GROCERY = "[{\"itemId\":1,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Ghee\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":490},{\"itemId\":2,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Whole Wheat\",\"drawable\":\"\",\"quantity\":\"5 kg\",\"price\":170},{\"itemId\":3,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Multigrain Atta\",\"drawable\":\"\",\"quantity\":\"5 kg\",\"price\":235},{\"itemId\":4,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Mustard Oil\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":125},{\"itemId\":5,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Regular Besan\",\"drawable\":\"\",\"quantity\":\"1 kg\",\"price\":85}]";
    public static final String JSON_ITEMS_HOUSEHOLD_NEEDS = "[{\"itemId\":1,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Dishwash bar\",\"drawable\":\"\",\"quantity\":\"200 gm\",\"price\":47},{\"itemId\":2,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Detergent Powder\",\"drawable\":\"\",\"quantity\":\"1 kg\",\"price\":85},{\"itemId\":3,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Toilet Cleaner\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":131},{\"itemId\":4,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Mosquito Repellent\",\"drawable\":\"\",\"quantity\":\"10 units\",\"price\":10},{\"itemId\":5,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Floor cleaner\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":133}]";
    public static final String JSON_ITEMS_PERSONAL_CARE = "[{\"itemId\":1,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Toothpaste\",\"drawable\":\"\",\"quantity\":\"200 gm\",\"price\":75},{\"itemId\":2,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Soap\",\"drawable\":\"\",\"quantity\":\"75 gm\",\"price\":15},{\"itemId\":3,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Sanitary Napkin\",\"drawable\":\"\",\"quantity\":\"30 units\",\"price\":260},{\"itemId\":4,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Samphoo\",\"drawable\":\"\",\"quantity\":\"200 ml\",\"price\":152},{\"itemId\":5,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Hand wash\",\"drawable\":\"\",\"quantity\":\"900 ml\",\"price\":140}]";
    public static final String JSON_ITEMS_BREAKFAST = "[{\"itemId\":1,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Toned Milk\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":60},{\"itemId\":2,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Soap\",\"drawable\":\"\",\"quantity\":\"Butter\",\"price\":42},{\"itemId\":3,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Milk\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":64},{\"itemId\":4,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Cholestrol Milk\",\"drawable\":\"\",\"quantity\":\"1 lt\",\"price\":70},{\"itemId\":5,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Oats\",\"drawable\":\"\",\"quantity\":\"40 gm\",\"price\":15}]";

    // keys..
    public static final String KEY_IS_LOGGED_IN = "is_logged_in";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_STORE = "key_store";
    public static final String KEY_CATEGORY_ID = "key_category_id";
    public static final String KEY_ORDER_ID = "key_order_id";
    public static final String KEY_ORDER = "key_order";
    public static final String KEY_STORE_ID = "key_store_id";
    public static final String KEY_IS_CATEGORY_LOADED = "is_category_loaded";
    public static final String KEY_YES = "Yes";
    public static final String KEY_NO = "No";
}
