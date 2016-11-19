package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class Store extends SugarRecord implements Serializable {
    public String storeId = "";
    public String categoryIds = "";
    public String name = "";
    public int drawable = 0;
    public String rating = "";
    public String locality = "";
    public String city = "";
}
