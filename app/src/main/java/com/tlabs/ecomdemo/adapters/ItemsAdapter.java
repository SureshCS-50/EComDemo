package com.tlabs.ecomdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.Item;
import com.tlabs.ecomdemo.models.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 09/11/16.
 */

public class ItemsAdapter extends BaseAdapter{

    private Activity mActivity;
    private LayoutInflater mInflater;
    public List<Item> mItems;
    public boolean[] itemsSelected;

    public ItemsAdapter(Activity activity, List<Item> items) {
        this.mActivity = activity;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mItems = items;
        this.itemsSelected = new boolean[this.getCount()];
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int position) {
        return mItems.get(position);
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

            view = mInflater.inflate(R.layout.lyt_item, null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
//            viewHolder.txtNameIndex = (TextView) view.findViewById(R.id.txtNameIndex);
            viewHolder.txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            viewHolder.txtQuantity = (TextView) view.findViewById(R.id.txtQuantity);
            viewHolder.checkbox = (CheckBox) view.findViewById(R.id.itemCheckBox);
            viewHolder.imgCategory = (ImageView) view.findViewById(R.id.imgCategory);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Item item = mItems.get(position);

        viewHolder.txtName.setText(item.name);
//        viewHolder.txtNameIndex.setText(item.name.substring(0, 1));
        viewHolder.txtPrice.setText("QR "+item.price);
        viewHolder.txtQuantity.setText(item.quantity);
        viewHolder.imgCategory.setImageResource(item.drawable);

        viewHolder.checkbox.setId(position);
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                CheckBox cb = (CheckBox) v;
                int id = cb.getId();
                if (itemsSelected[id]){
                    cb.setChecked(false);
                    itemsSelected[id] = false;
                } else {
                    cb.setChecked(true);
                    itemsSelected[id] = true;
                }
            }
        });
        viewHolder.checkbox.setChecked(itemsSelected[position]);
        viewHolder.id = position;

        return view;
    }

    static class ViewHolder {
        TextView txtName, /*txtNameIndex,*/ txtPrice, txtQuantity;
        CheckBox checkbox;
        ImageView imgCategory;
        int id;
    }
}
