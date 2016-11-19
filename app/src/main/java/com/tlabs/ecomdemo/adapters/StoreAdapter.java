package com.tlabs.ecomdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.helpers.DataManager;
import com.tlabs.ecomdemo.models.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 09/11/16.
 */

public class StoreAdapter extends BaseAdapter implements Filterable {

    public List<Store> mFilteredStores;
    private Activity mActivity;
    private LayoutInflater mInflater;
    private List<Store> mStores;
    private int mResourceId;
    private boolean mIsStoreSearch;

    public StoreAdapter(Activity activity, boolean isStoreSearch) {
        DataManager dataManager = new DataManager();
        this.mActivity = activity;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mStores = dataManager.getAllStores();
        if (this.mStores == null) {
            this.mStores = new ArrayList<>();
        }

        if (!isStoreSearch) {
            mFilteredStores = dataManager.getAllStores();
            if (this.mFilteredStores == null)
                this.mFilteredStores = new ArrayList<>();
        }

        this.mResourceId = (isStoreSearch) ? R.layout.lyt_store_search_item : R.layout.lyt_store_item;
        this.mIsStoreSearch = isStoreSearch;
    }

    @Override
    public int getCount() {
        return mFilteredStores.size();
    }

    @Override
    public Store getItem(int position) {
        return mFilteredStores.get(position);
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

            view = mInflater.inflate(mResourceId, null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
            viewHolder.txtLocality = (TextView) view.findViewById(R.id.txtLocality);
            if (!mIsStoreSearch) {
                viewHolder.txtCity = (TextView) view.findViewById(R.id.txtCity);
                viewHolder.imgStoreLogo = (ImageView) view.findViewById(R.id.imgStoreLogo);
            }
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Store store = mFilteredStores.get(position);

        viewHolder.txtName.setText(store.name);
        if (!mIsStoreSearch) {
            viewHolder.txtLocality.setText(store.locality);
            viewHolder.txtCity.setText(store.city);
            viewHolder.imgStoreLogo.setImageResource(store.drawable);
        } else{
            viewHolder.txtLocality.setText(store.locality+", "+store.city);
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        try {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();

                    if (constraint != null && constraint.length() != 0) {
                        List<Store> searchResult = new ArrayList<>();
                        searchResult.clear();
                        for (Store s : mStores) {
                            if (s.name.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                                searchResult.add(s);
                            }
                        }
                        results.values = searchResult;
                        results.count = searchResult.size();
                    }
                    return results;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    mFilteredStores = (ArrayList<Store>) results.values;
                    if (mFilteredStores == null) {
                        mFilteredStores = new ArrayList<>();
                    }
                    notifyDataSetChanged();
                }
            };
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static class ViewHolder {
        TextView txtName, txtLocality, txtCity;
        ImageView imgStoreLogo;
    }
}
