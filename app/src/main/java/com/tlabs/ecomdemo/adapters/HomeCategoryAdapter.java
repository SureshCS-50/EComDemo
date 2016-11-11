package com.tlabs.ecomdemo.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.Category;
import com.tlabs.ecomdemo.ui.activities.HomeActivity;
import com.tlabs.ecomdemo.ui.activities.ItemsActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 05/11/16.
 */

public class HomeCategoryAdapter extends BaseAdapter {

    public List<Category> mCategories = new ArrayList<Category>();
    private Activity mActivity;

    public HomeCategoryAdapter(Activity activity, List<Category> mCategories) {
        this.mActivity = activity;
        this.mCategories = mCategories;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int i) {
        return mCategories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View categoryRow;
        if (convertView == null) {
            categoryRow = View.inflate(mActivity, R.layout.lyt_home_category, null);
        } else {
            categoryRow = convertView;
        }
        final Category category = mCategories.get(i);
        categoryRow.setId(1000+i);
        ((TextView) categoryRow.findViewById(R.id.txtHomeItemTitle)).setText(category.name);
        ((TextView) categoryRow.findViewById(R.id.txtHomeItemDescription)).setText(category.description);
        categoryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager.showStoresActivity(mActivity, category.categoryId);
//                ActivityManager.showCartActivity(mActivity, 1);
            }
        });
        return categoryRow;
    }

    public void addItem(Category category) {
        mCategories.add(category);
    }

    public void setItems(ArrayList<Category> categories){
        if(categories != null) {
            this.mCategories.clear();
            this.mCategories.addAll(categories);
        }
    }

}
