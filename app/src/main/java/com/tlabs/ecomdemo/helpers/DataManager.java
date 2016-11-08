package com.tlabs.ecomdemo.helpers;

import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.models.UserAccount;

import java.util.List;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class DataManager {

    public boolean checkUserLogin(String email, String password) {
        List<UserAccount> UserAccounts = UserAccount.find(UserAccount.class, "email = ? and password = ?", new String[]{email, password}, null, null, null);
        if (UserAccounts != null && UserAccounts.size() > 0) {
            return true;
        }

        return false;
    }

}
