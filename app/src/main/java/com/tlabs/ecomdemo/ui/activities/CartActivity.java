package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.adapters.CartItemsAdapter;
import com.tlabs.ecomdemo.listeners.CartAdapterInteractor;
import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.dto.CartItemMeta;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.Constants;

import java.util.List;

public class CartActivity extends BaseActivity implements CartAdapterInteractor {

    private long mOrderId;
    private List<CartItem> mItems;
    private Toolbar mToolbar;
    private ListView mListViewItems;
    private CartItemsAdapter mItemsAdapter;
    private Button mBtnBuyNow;
    private TextView mTxtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Bundle extras = getIntent().getExtras();
        mOrderId = extras.getLong(Constants.KEY_ORDER_ID, 0);

        mTxtTotal = (TextView) findViewById(R.id.txtTotal);

        mItems = mDataManager.getItemsByOrderId(mOrderId);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        mListViewItems = (ListView) findViewById(R.id.listItems);
        mItemsAdapter = new CartItemsAdapter(this, this, mItems);
        mListViewItems.setAdapter(mItemsAdapter);

        mBtnBuyNow = (Button) findViewById(R.id.btnBuy);
        mBtnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void calculateTotal(List<CartItemMeta> items) {
        double totalValue = 0;
        for(CartItemMeta item : items){
            totalValue = totalValue + item.netPrice;
        }
        mTxtTotal.setText("Rs."+String.valueOf(totalValue));
    }
}
