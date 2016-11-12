package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class CartItem extends SugarRecord {
    public String itemId = "";
    public String itemName = "";
    public double itemPrice = 0;
    public String itemQuantity = "";
    public int drawable;
    public int oneQuantity = 1; // number x quantity of this item
    public int netQuantity = 1; // number x quantity of this item
    public String netPrice = ""; // quantity x itemPrice of this item
    public long orderId = 0;
    public String storeId = "";
    public String categoryId = "";
    public String storeName = "";
    public String categoryName = "";
}
