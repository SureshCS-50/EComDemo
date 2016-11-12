package com.tlabs.ecomdemo.utils;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class Constants {
    public static final String PREFERENCE_NAME = "e_com_preference_manager";

    // constants..
    public static final String JSON_CATEGORIES = "[{\"categoryId\":1,\"name\":\"Fruits & Vegetables\",\"drawable\":0,\"description\":\"Fruit & Vegetable Baskets, Cut Frush, Sprouts & Herbs\"},{\"categoryId\":2,\"name\":\"Grocery & Staples\",\"drawable\":0,\"description\":\"Rice & Flour, Edible Oils & Ghee, Pulses, Spices, Salt & Sugar, Dry Fruits & Nuts\"},{\"categoryId\":3,\"name\":\"Household Needs\",\"drawable\":0,\"description\":\"Laundry Detergents, Dishwashers & Cleaners, Repellents and Fresheners\"},{\"categoryId\":4,\"name\":\"Personal Care\",\"drawable\":0,\"description\":\"Body & Face Care, Hair Care, Oral Care, Grooming Needs, Cosmetics, Fragrances\"},{\"categoryId\":5,\"name\":\"Breakfast & Dairy\",\"drawable\":0,\"description\":\"Milk & Milk Products, Paneer & Curd, Butter & Cheese, Bread & Eggs\"}]";
    public static final String JSON_STORES = "[{\"storeId\":1,\"name\":\"Al Meyar Market\",\"drawable\":\"0\",\"rating\":\"5.0\",\"locality\":\"Guindy\",\"city\":\"Chennai\"},{\"storeId\":2,\"name\":\"Spinneys\",\"drawable\":\"0\",\"rating\":\"4.0\",\"locality\":\"Guindy\",\"city\":\"Chennai\"},{\"storeId\":3,\"name\":\"Strand bakery\",\"drawable\":\"0\",\"rating\":\"4.8\",\"locality\":\"Alandur\",\"city\":\"Chennai\"},{\"storeId\":4,\"name\":\"Monoprix\",\"drawable\":\"0\",\"rating\":\"4.9\",\"locality\":\"Ashok Nagar\",\"city\":\"Chennai\"},{\"storeId\":5,\"name\":\"Lulu hypermarket Al Gharrafa\",\"drawable\":\"0\",\"rating\":\"5.0\",\"locality\":\"Royapettah\",\"city\":\"Chennai\"},{\"storeId\":6,\"name\":\"Spinneys (Pearl main store)\",\"drawable\":\"0\",\"rating\":\"5.0\",\"locality\":\"Royapettah\",\"city\":\"Chennai\"}]";
    public static final String JSON_ITEMS_FRUITS = "[{\"itemId\":1,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Green apple\",\"drawable\":0,\"quantity\":\"6 units\",\"price\":7},{\"itemId\":2,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Anaar\",\"drawable\":0,\"quantity\":\"6 units\",\"price\":5},{\"itemId\":3,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Banana\",\"drawable\":0,\"quantity\":\"12 units\",\"price\":12},{\"itemId\":4,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Fuji Apple\",\"drawable\":0,\"quantity\":\"6 units\",\"price\":10},{\"itemId\":5,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Plum\",\"drawable\":0,\"quantity\":\"250 gm\",\"price\":50},{\"itemId\":6,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Pineapple\",\"drawable\":0,\"quantity\":\"1 unit\",\"price\":50},{\"itemId\":7,\"categoryIds\":1,\"storeIds\":1,\"name\":\"Papaya\",\"drawable\":0,\"quantity\":\"1 unit\",\"price\":50}]";
    public static final String JSON_ITEMS_GROCERY = "[{\"itemId\":1,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Gold winner\",\"drawable\":0,\"quantity\":\"5 lt\",\"price\":490},{\"itemId\":2,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Almonds\",\"drawable\":0,\"quantity\":\"500 gm\",\"price\":170},{\"itemId\":3,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Walnuts\",\"drawable\":0,\"quantity\":\"200 gm\",\"price\":235},{\"itemId\":4,\"categoryIds\":2,\"storeIds\":1,\"name\":\"Sugar free Gold\",\"drawable\":0,\"quantity\":\"11 gm\",\"price\":125}]";
    public static final String JSON_ITEMS_HOUSEHOLD_NEEDS = "[{\"itemId\":1,\"categoryIds\":3,\"storeIds\":1,\"name\":\"All out Liquid vapourizer\",\"drawable\":0,\"quantity\":\"45 ml\",\"price\":47},{\"itemId\":2,\"categoryIds\":3,\"storeIds\":1,\"name\":\"Harpic Power plus Toiler cleaner\",\"drawable\":0,\"quantity\":\"1 lt\",\"price\":85}]";
    public static final String JSON_ITEMS_PERSONAL_CARE = "[{\"itemId\":1,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Nivea body lotion\",\"drawable\":0,\"quantity\":\"400 ml\",\"price\":75},{\"itemId\":2,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Nivea Whitening lotion\",\"drawable\":0,\"quantity\":\"250 ml\",\"price\":15},{\"itemId\":3,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Vaseline Healthy White Lotion\",\"drawable\":0,\"quantity\":\"300 ml\",\"price\":260},{\"itemId\":4,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Pond's triple vitamin\",\"drawable\":0,\"quantity\":\"300 ml\",\"price\":152},{\"itemId\":5,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Axe dark\",\"drawable\":0,\"quantity\":\"100 gm\",\"price\":140},{\"itemId\":6,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Lakme\",\"drawable\":0,\"quantity\":\"60 ml\",\"price\":152},{\"itemId\":7,\"categoryIds\":4,\"storeIds\":1,\"name\":\"Yardley Gold\",\"drawable\":0,\"quantity\":\"250 gm\",\"price\":140}]";
    public static final String JSON_ITEMS_BREAKFAST = "[{\"itemId\":1,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Nestle a+ Naurish Tonned Milk\",\"drawable\":0,\"quantity\":\"1lt\",\"price\":7},{\"itemId\":2,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Kellogg's Special K (Carton)\",\"drawable\":0,\"quantity\":\"435 gm\",\"price\":5},{\"itemId\":3,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Sofit Chocolate Soy Milk\",\"drawable\":0,\"quantity\":\"200 ml\",\"price\":12},{\"itemId\":4,\"categoryIds\":5,\"storeIds\":1,\"name\":\"Quaker - oats\",\"drawable\":0,\"quantity\":\"250gm\",\"price\":10}]";

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
