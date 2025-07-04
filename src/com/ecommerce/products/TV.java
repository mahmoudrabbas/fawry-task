package com.ecommerce.products;

import com.ecommerce.entities.Product;
import com.ecommerce.abstracts.Shippable;

public class TV extends Product implements Shippable {

    private final double weight;


    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
