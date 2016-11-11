package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class Category extends SugarRecord implements Serializable {
    public String categoryId = "";
    public String name = "";
    public String drawable = "";
    public String description = "";
}
