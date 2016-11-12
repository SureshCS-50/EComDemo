package com.tlabs.ecomdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.Store;
import com.tlabs.ecomdemo.utils.Constants;
import com.tlabs.ecomdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 09/11/16.
 */

public class StoreAdapter extends BaseAdapter{

    private Activity mActivity;
    private LayoutInflater mInflater;
    private List<Store> mStores;

    public StoreAdapter(Activity activity, List<Store> stores) {
        this.mActivity = activity;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mStores = stores;
        if(this.mStores == null){
            this.mStores = new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return mStores.size();
    }

    @Override
    public Store getItem(int position) {
        return mStores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();

            view = mInflater.inflate(R.layout.lyt_category_item, null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Store store = mStores.get(position);

        viewHolder.txtName.setText(store.name);

        return view;
    }

    static class ViewHolder {
        TextView txtName, txtNameIndex, txtLocality, txtRating;
    }
}
