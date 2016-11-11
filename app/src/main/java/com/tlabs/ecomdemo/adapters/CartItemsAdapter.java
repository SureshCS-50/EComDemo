package com.tlabs.ecomdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.helpers.DataManager;
import com.tlabs.ecomdemo.listeners.CartAdapterInteractor;
import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.Item;
import com.tlabs.ecomdemo.models.dto.CartItemMeta;
import com.tlabs.ecomdemo.utils.widget.FloatPickerWidget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 09/11/16.
 */

public class CartItemsAdapter extends BaseAdapter{

    private Activity mActivity;
    private LayoutInflater mInflater;
    public List<CartItem> mItems;
    private List<CartItemMeta> mMeta;
    private DataManager mDataManager;
    private CartAdapterInteractor mCartAdapterInteractor;

    public CartItemsAdapter(Activity activity, CartAdapterInteractor cartAdapterInteractor, List<CartItem> items) {
        this.mActivity = activity;
        this.mDataManager = new DataManager();
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mCartAdapterInteractor = cartAdapterInteractor;
        this.mItems = items;
        this.mMeta = new ArrayList<>();
        for(CartItem item : mItems){
            CartItemMeta meta = new CartItemMeta(String.valueOf(item.netQuantity),
                    item.itemPrice,
                    item.itemPrice * item.netQuantity);
            mMeta.add(meta);
        }

        mCartAdapterInteractor.calculateTotal(mMeta);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public CartItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            view = mInflater.inflate(R.layout.lyt_cart_item, null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
            viewHolder.txtNameIndex = (TextView) view.findViewById(R.id.txtNameIndex);
            viewHolder.txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            viewHolder.txtQuantity = (TextView) view.findViewById(R.id.txtQuantity);
            viewHolder.numberPicker = (FloatPickerWidget) view.findViewById(R.id.numberPicker);
            viewHolder.txtDelete = (TextView) view.findViewById(R.id.txtDelete);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final CartItem item = mItems.get(position);

        viewHolder.txtName.setText(item.itemName);
        viewHolder.txtNameIndex.setText(item.itemName.substring(0, 1));
        String quantity = "("+item.itemQuantity+" = Rs."+item.itemPrice+")";
        viewHolder.txtQuantity.setText(quantity);
        String value = "Rs."+item.itemPrice * Integer.valueOf(mMeta.get(position).quantity);
        viewHolder.txtPrice.setText(value);

        viewHolder.id = position;
        viewHolder.numberPicker.setValue(Integer.valueOf(mMeta.get(position).quantity));

        viewHolder.numberPicker.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mMeta.get(viewHolder.id).quantity = s.toString();
                double value = mMeta.get(viewHolder.id).price * Float.valueOf(s.toString());
                String netPrice = "Rs."+value;
                viewHolder.txtPrice.setText(netPrice);
                mMeta.get(viewHolder.id).netPrice = value;
                mCartAdapterInteractor.calculateTotal(mMeta);
            }
        });

        viewHolder.txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataManager.removeItemByOrderId(mItems.get(viewHolder.id).orderId, mItems.get(viewHolder.id).itemId);
                mItems.remove(viewHolder.id);
                mMeta.remove(viewHolder.id);
                mCartAdapterInteractor.calculateTotal(mMeta);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    static class ViewHolder {
        TextView txtName, txtNameIndex, txtPrice, txtQuantity;
        FloatPickerWidget numberPicker;
        TextView txtDelete;
        int id;
    }
}
