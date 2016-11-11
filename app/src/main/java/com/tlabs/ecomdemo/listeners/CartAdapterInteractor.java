package com.tlabs.ecomdemo.listeners;

import com.tlabs.ecomdemo.models.dto.CartItemMeta;

import java.util.List;

/**
 * Created by Sureshkumar on 12/11/16.
 */

public interface CartAdapterInteractor {

    public void calculateTotal(List<CartItemMeta> items);
}
