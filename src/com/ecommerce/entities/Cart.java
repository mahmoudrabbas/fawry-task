package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }


    public void add(Product item,  int quantity){
        items.add(new CartItem(item, quantity));
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clearCart(){
        items.clear();
    }
}
