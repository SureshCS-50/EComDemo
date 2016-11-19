package com.tlabs.ecomdemo.helpers;

import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.models.Item;
import com.tlabs.ecomdemo.models.Store;
import com.tlabs.ecomdemo.models.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class DataManager {

    public List<Category> getAllCategories(){
        List<Category> categories = Category.find(Category.class, "category_id != ?", new String[]{"0"}, null, null, null);
        if (categories != null && categories.size() > 0) {
            return categories;
        }

        return new ArrayList<>();
    }

    public List<Store> getAllStores(){
        List<Store> stores = Store.listAll(Store.class);
        if (stores != null && stores.size() > 0) {
            return stores;
        }

        return new ArrayList<>();
    }

    public List<CartOrder> getAllOrders(){
        List<CartOrder> orders = CartOrder.listAll(CartOrder.class);
        if(orders != null && orders.size() > 0){
            return orders;
        }
        return new ArrayList<>();
    }

    public List<Item> getItemsByCategory(String categoryId) {
        if(!categoryId.equals("0")) {
            List<Item> items = Item.find(Item.class, "category_ids = ?", new String[]{categoryId}, null, null, null);
            if (items != null && items.size() > 0) {
                return items;
            }
        } else{
            List<Item> items = Item.listAll(Item.class);
            if(items != null && items.size() > 0){
                return items;
            }
        }

        return new ArrayList<>();
    }

    public boolean checkUserLogin(String email, String password) {
        List<UserAccount> UserAccounts = UserAccount.find(UserAccount.class, "email = ? and password = ?", new String[]{email, password}, null, null, null);
        if (UserAccounts != null && UserAccounts.size() > 0) {
            return true;
        }

        return false;
    }

    public void clearData(){
        Category.deleteAll(Category.class);
        Store.deleteAll(Store.class);
        Item.deleteAll(Item.class);
    }

    public Store getStoreById(String storeId) {
        List<Store> stores = Store.find(Store.class, "store_id = ?", new String[]{storeId}, null, null, null);
        if (stores != null && stores.size() > 0) {
            return stores.get(0);
        }

        return null;
    }

    public Category getCategoryById(String categoryId) {
        List<Category> categories = Category.find(Category.class, "category_id = ?", new String[]{categoryId}, null, null, null);
        if (categories != null && categories.size() > 0) {
            return categories.get(0);
        }

        return null;
    }

    public List<CartItem> getItemsByOrderId(long orderId) {
        List<CartItem> items = CartItem.find(CartItem.class, "order_id = ?", new String[]{String.valueOf(orderId)}, null, null, null);
        if (items != null && items.size() > 0) {
            return items;
        }

        return new ArrayList<>();
    }

    public void removeItemByOrderId(long orderId, String itemId) {
        CartItem.deleteAll(CartItem.class, "order_id = ? and item_id = ?", new String[]{String.valueOf(orderId), itemId});
    }

    public UserAccount getUserAccountByEmail(String email) {
        List<UserAccount> accounts = UserAccount.find(UserAccount.class, "email = ?", new String[]{email}, null, null, null);
        if (accounts != null && accounts.size() > 0) {
            return accounts.get(0);
        }

        return null;
    }

    public void removeAllItemsByOrderId(Long orderId) {
        CartItem.deleteAll(CartItem.class, "order_id = ?", new String[]{String.valueOf(orderId)});
    }

    public CartOrder getCartOrderById(long orderId) {
        List<CartOrder> orders = CartOrder.find(CartOrder.class, "order_id = ?", new String[]{String.valueOf(orderId)}, null, null, null);
        if(orders != null && orders.size() > 0){
            return orders.get(0);
        }
        return null;
    }
}
