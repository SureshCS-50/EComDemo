package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class Item extends SugarRecord {
    public String itemId = "";
    public String categoryIds = "";
    public String storeIds = "";
    public String name = "";
    public String drawable = "";
    public String quantity = "";
    public double price = 0;
}
