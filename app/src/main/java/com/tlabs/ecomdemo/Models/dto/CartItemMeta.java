package com.tlabs.ecomdemo.models.dto;

/**
 * Created by Sureshkumar on 12/11/16.
 */

public class CartItemMeta {

    public String quantity = "";
    public double price = 1;
    public double netPrice = 0;

    public CartItemMeta(String quantity, double price, double netPrice){
        this.quantity = quantity;
        this.price = price;
        this.netPrice = netPrice;
    }
}
