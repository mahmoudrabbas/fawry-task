package com.ecommerce.products;

import com.ecommerce.entities.Product;
import com.ecommerce.abstracts.Expirable;

import java.time.LocalDate;

public class Biscuit extends Product implements Expirable {

    private LocalDate expireDate;


    public Biscuit(String name, double price, int quantity, LocalDate expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
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
}
