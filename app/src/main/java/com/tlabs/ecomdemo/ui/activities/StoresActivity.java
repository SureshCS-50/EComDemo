package com.tlabs.ecomdemo.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.adapters.StoreAdapter;
import com.tlabs.ecomdemo.models.Store;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Constants;

import java.util.List;

public class StoresActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ListView mListViewStores;
    private StoreAdapter mStoreAdapter;
    private String mCategoryId = "";
    private List<Store> mStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Bundle extras = getIntent().getExtras();
        mCategoryId = extras.getString(Constants.KEY_CATEGORY_ID, "");

        mStores = mDataManager.getAllStores();

        mListViewStores = (ListView) findViewById(R.id.listItems);
        mStoreAdapter = new StoreAdapter(this, mStores);
        mListViewStores.setAdapter(mStoreAdapter);
        mListViewStores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Store store = ((StoreAdapter)parent.getAdapter()).getItem(position);
                ActivityManager.showItemsActivity(StoresActivity.this, mCategoryId, store.storeId);
            }
        });
    }
}
