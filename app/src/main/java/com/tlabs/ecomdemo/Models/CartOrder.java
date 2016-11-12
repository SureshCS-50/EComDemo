package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Sureshkumar on 11/11/16.
 */

public class CartOrder extends SugarRecord implements Serializable{
    public Long orderId = 0l;
    public String storeId = "";
    public String storeName = "";
    public String categoryId = "";
    public String categoryName = "";
    public String netPrice = "";
}
