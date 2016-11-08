package com.tlabs.ecomdemo.models;

import com.orm.SugarRecord;

/**
 * Created by Sureshkumar on 06/11/16.
 */

public class UserAccount extends SugarRecord {
    public String name = "";
    public String email = "";
    public String password = "";
}