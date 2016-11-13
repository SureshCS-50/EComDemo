package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.CartOrderDetails;
import com.tlabs.ecomdemo.adapters.ExCartOrderAdapter;
import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.ui.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CartHistoryActivity extends BaseActivity {

    private Toolbar mToolbar;
    private List<CartOrder> mCartOrders;

    private ExpandableListView mExListCartOrders;
    private ExCartOrderAdapter mExCartOrderAdapter;
    private List<CartOrderDetails> mCartOrderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_history);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Cart History");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mCartOrders = mDataManager.getAllOrders();
        mCartOrderDetails = new ArrayList<>();

        for(CartOrder order : mCartOrders){
            CartOrderDetails orderDetails = new CartOrderDetails();
            orderDetails.orderId = order.orderId;
            orderDetails.categoryId = order.categoryId;
            orderDetails.categoryName = order.categoryName;
            orderDetails.storeId = order.storeId;
            orderDetails.storeName = order.storeName;
            orderDetails.items = mDataManager.getItemsByOrderId(orderDetails.orderId);
            double netPrice = 0;
            for(CartItem item : orderDetails.items){
                netPrice = netPrice + (item.netQuantity * item.itemPrice);
            }
            orderDetails.netPrice = "QR "+netPrice;
            mCartOrderDetails.add(orderDetails);
        }

        mExListCartOrders = (ExpandableListView) findViewById(R.id.exListItems);
        mExCartOrderAdapter = new ExCartOrderAdapter(this, mCartOrderDetails);
        mExListCartOrders.setAdapter(mExCartOrderAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
