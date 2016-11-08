package com.tlabs.ecomdemo.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 05/11/16.
 */

public class HomeCategoryAdapter extends BaseAdapter {

    public List<Category> mCategories = new ArrayList<Category>();
    private Context mContext;

    public HomeCategoryAdapter(Context context, List<Category> mCategories) {
        this.mContext = context;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View categoryRow;
        if (convertView == null) {
            categoryRow = View.inflate(mContext, R.layout.lyt_home_category, null);
        } else {
            categoryRow = convertView;
        }
        categoryRow.setId(1000+i);
        ((TextView) categoryRow.findViewById(R.id.txtHomeItemTitle)).setText(mCategories.get(i).name);
        ((TextView) categoryRow.findViewById(R.id.txtHomeItemDescription)).setText(mCategories.get(i).description);
        return categoryRow;
    }

    public void addItem(Category category) {
        mCategories.add(category);
    }

}
