package com.ecommerce.products;

import com.ecommerce.entities.Product;
import com.ecommerce.abstracts.Expirable;
import com.ecommerce.abstracts.Shippable;

import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable {
    private LocalDate expireDate;

    private final double weight;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expireDate.isBefore(LocalDate.now());
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
