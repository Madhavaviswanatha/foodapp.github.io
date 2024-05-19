package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class CartCreator {
    private Map<Integer, Cartitem> cart;

    public CartCreator() {
        cart = new HashMap<>();
    }

    public void addCartitem(Cartitem item) {
        if (cart.containsKey(item.getItemId())) {
            Cartitem cr = cart.get(item.getItemId());
            cr.setQuantity(cr.getQuantity() + item.getQuantity());
            cart.put(cr.getItemId(), cr);
        } else {
            cart.put(item.getItemId(), item);
        }
    }

    public void updateCartitem(int itemId, int quantity) {
        if (cart.containsKey(itemId)) {
            cart.get(itemId).setQuantity(quantity);
        }
    }

    public void removeCartitem(int itemId) {
        if(cart.containsKey(itemId)) {
            cart.remove(itemId);
        }
    }

    public Map<Integer, Cartitem> getCartItems() {
        return cart;
    }
}
