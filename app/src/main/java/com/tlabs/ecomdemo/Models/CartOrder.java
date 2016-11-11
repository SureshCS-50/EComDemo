package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

/**
 * Created by Sureshkumar on 11/11/16.
 */

public class CartOrder extends SugarRecord {
    public String orderId = "";
    public String storeId = "";
    public String storeName = "";
    public String categoryId = "";
    public String categoryName = "";
}
