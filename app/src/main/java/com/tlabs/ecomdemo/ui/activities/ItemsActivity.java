package com.tlabs.ecomdemo.ui.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.adapters.ItemsAdapter;
import com.tlabs.ecomdemo.adapters.StoreAdapter;
import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.models.Item;
import com.tlabs.ecomdemo.models.Store;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Constants;
import com.tlabs.ecomdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends BaseActivity {

    private String mStoreId;
    private String mCategoryId;
    private List<Item> mItems;
    private Toolbar mToolbar;
    private ListView mListViewItems;
    private ItemsAdapter mItemsAdapter;
    private Button  mBtnAddToCart;
    private Store mStore;
    private Category mCategory;
    private CartOrder mCartOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        Bundle extras = getIntent().getExtras();
        mStoreId = extras.getString(Constants.KEY_STORE_ID, "");
        mCategoryId = extras.getString(Constants.KEY_CATEGORY_ID, "");

        mStore = mDataManager.getStoreById(mStoreId);
        mCategory = mDataManager.getCategoryById(mCategoryId);
        mItems = mDataManager.getItemsByCategory(mCategoryId);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(mStore.name);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mListViewItems = (ListView) findViewById(R.id.listItems);
        mItemsAdapter = new ItemsAdapter(this, mItems);
        mListViewItems.setAdapter(mItemsAdapter);

        mBtnAddToCart = (Button) findViewById(R.id.btnCart);
        mBtnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] selectedItemIds = mItemsAdapter.itemsSelected;
                List<Item> allItems = mItemsAdapter.mItems;
                boolean isItemsAdded = false;

                mCartOrder = new CartOrder();
                mCartOrder.storeId = mStoreId;
                mCartOrder.storeName = mStore.name;
                mCartOrder.categoryId = mCategoryId;
                mCartOrder.categoryName = mCategory.name;
                mCartOrder.save();
                mCartOrder.orderId = mCartOrder.getId();
                mCartOrder.save();



                for(int i = 0; i < selectedItemIds.length; i++){
                    if(selectedItemIds[i]){
                        isItemsAdded = true;
                        Item selectedItem = allItems.get(i);
                        CartItem cartItem = new CartItem();
                        cartItem.itemId = selectedItem.itemId;
                        cartItem.itemName = selectedItem.name;
                        cartItem.itemPrice = selectedItem.price;
                        cartItem.itemQuantity = selectedItem.quantity;
                        cartItem.storeId = mStoreId;
                        cartItem.categoryId = mCategoryId;
                        cartItem.orderId = mCartOrder.getId();
                        cartItem.save();
                    }
                }

                if(isItemsAdded){
                    ActivityManager.showCartActivity(ItemsActivity.this, mCartOrder.getId());
                } else{
                    Toast.makeText(ItemsActivity.this, "Please select atleast one item to continue", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        boolean[] selectedItemIds = mItemsAdapter.itemsSelected;
        boolean isItemsAdded = false;
        for(int i = 0; i < selectedItemIds.length; i++) {
            if (selectedItemIds[i]) {
                isItemsAdded = true;
                break;
            }
        }
        if(isItemsAdded){
            showItemSelectedAlertDialog();
        } else{
            super.onBackPressed();
        }
    }

    private void showItemSelectedAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setMessage("Are you sure, Do you want to continue?")
                .setPositiveButton(Constants.KEY_YES,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(mCartOrder != null){
                                    mDataManager.removeAllItemsByOrderId(mCartOrder.getId());
                                }
                                finish();
                            }
                        })
                .setNegativeButton(Constants.KEY_NO, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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
