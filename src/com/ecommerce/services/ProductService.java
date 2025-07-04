package com.ecommerce.services;

import com.ecommerce.entities.Product;

public class ProductService {
    private Product product;

    public ProductService(Product product){
        this.product = product;
    }

    public boolean checkQuantity(int quantity){
        return product.getQuantity()>=quantity;
    }

    public void reduceQuantity(int quantity){
        if(checkQuantity(quantity)) System.out.println("Quantity is out of stock or expired");
        product.setQuantity(product.getQuantity()-quantity);
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
