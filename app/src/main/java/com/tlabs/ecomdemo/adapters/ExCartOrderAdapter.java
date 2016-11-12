package com.tlabs.ecomdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.CartItem;
import com.tlabs.ecomdemo.models.CartOrderDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sureshkumar on 05/10/16.
 */

public class ExCartOrderAdapter extends BaseExpandableListAdapter {

    Context mContext;
    List<CartOrderDetails> mCartOrderDetails;
    int mItemLayoutId;
    int mGroupLayoutId;

    public ExCartOrderAdapter(Context context, List<CartOrderDetails> cartOrderDetails) {
        this.mContext = context;
        this.mCartOrderDetails = cartOrderDetails;
        if (mCartOrderDetails == null) {
            mCartOrderDetails = new ArrayList<>();
        }
        this.mItemLayoutId = R.layout.lyt_card_cart_history_item;
        this.mGroupLayoutId = R.layout.lyt_cart_history_header;
    }

    @Override
    public int getGroupCount() {
        if (mCartOrderDetails != null) {
            return mCartOrderDetails.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int position) {
        if (mCartOrderDetails != null) {
            return mCartOrderDetails.get(position).items.size();
        }
        return 0;
    }

    @Override
    public CartOrderDetails getGroup(int groupPosition) {
        return mCartOrderDetails.get(groupPosition);
    }

    @Override
    public CartItem getChild(int groupPosition, int childPosition) {
        return mCartOrderDetails.get(groupPosition).items.get(childPosition);
    }

    @Override
    public long getGroupId(int position) {
        return mCartOrderDetails.get(position).hashCode();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return mCartOrderDetails.get(groupPosition).items.get(childPosition).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        try {

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.lyt_cart_history_header, parent, false);
            }

            TextView txtStoreName = (TextView) view.findViewById(R.id.txtStoreName);
            TextView txtCategoryName = (TextView) view.findViewById(R.id.txtCategoryName);
            TextView txtNetPrice = (TextView) view.findViewById(R.id.txtNetPrice);

            CartOrderDetails category = mCartOrderDetails.get(groupPosition);
            txtStoreName.setText(category.storeName);
            txtCategoryName.setText(category.categoryName);
            txtNetPrice.setText(category.netPrice);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        try {

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.lyt_card_cart_history_item, parent, false);
            }

            TextView txtName = (TextView) view.findViewById(R.id.txtName);
            TextView txtNameIndex = (TextView) view.findViewById(R.id.txtNameIndex);
            TextView txtProductInfo = (TextView) view.findViewById(R.id.txtItemInfo);
            TextView txtQuantityCount = (TextView) view.findViewById(R.id.txtQuantity);
            TextView txtPriceCount = (TextView) view.findViewById(R.id.txtPrice);
//            ImageView imgStatus = (ImageView) view.findViewById(R.id.imgAgentStatus);

            String name = "";
            CartItem item = mCartOrderDetails.get(groupPosition).items.get(childPosition);
            if (item != null) {
                txtName.setText(name);
                txtNameIndex.setText(name.substring(0, 1));
                txtProductInfo.setText("("+item.itemQuantity+" = Rs."+item.itemPrice+")");
                txtPriceCount.setText(item.netPrice);
                txtQuantityCount.setText(String.valueOf(item.netQuantity));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setItems(List<CartOrderDetails> cartOrderDetailsList) {
        this.mCartOrderDetails = (cartOrderDetailsList != null) ? cartOrderDetailsList : new ArrayList<CartOrderDetails>();
        notifyDataSetChanged();
    }

}
