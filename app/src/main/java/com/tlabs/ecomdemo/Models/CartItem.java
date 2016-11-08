package com.tlabs.ecomdemo.models;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class CartItem {
    public String cartId = ""; // will be useful if we had a plan to show cart history..
    public String itemId = "";
    public String itemName = "";
    public String itemPrice = "";
    public String quantity = "";
    public String netPrice = ""; // quantity x itemPrice of this item
}
