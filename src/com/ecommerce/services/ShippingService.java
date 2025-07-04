package com.ecommerce.services;

import com.ecommerce.entities.Product;

import java.util.HashMap;
import java.util.Map;

public class ShippingService {
    private Map<Product, Integer> shipping;

    public ShippingService() {
        shipping = new HashMap<>();
    }

    public void shipProduct(Product product, int quantity){
        shipping.put(product, quantity);
    }

    public void setShipping(Map<Product, Integer> shipping) {
        this.shipping = shipping;
    }

    public  Map<Product, Integer> getShipping() {
        return shipping;
    }
}
