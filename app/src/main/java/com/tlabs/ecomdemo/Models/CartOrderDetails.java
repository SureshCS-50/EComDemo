package com.tlabs.ecomdemo.models;

import com.tlabs.ecomdemo.models.CartItem;

import java.util.List;

/**
 * Created by Sureshkumar on 12/11/16.
 */

public class CartOrderDetails {
    public Long orderId = 0l;
    public String storeId = "";
    public String storeName = "";
    public String categoryId = "";
    public String categoryName = "";
    public String netPrice = "";
    public List<CartItem> items;
}
