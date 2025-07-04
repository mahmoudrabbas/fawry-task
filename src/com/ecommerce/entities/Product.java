package com.ecommerce.entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

//    protected double weight;

    public Product() {
    }
//
//    public Product(String name, double price, int quantity, double weight) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.weight = weight;
//    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean checkQuantity(int countOfItems){
        return this.quantity>=countOfItems;
    }

    public void reduceQuantity(int countOfItems){
        setQuantity(this.getQuantity()-countOfItems);
    }

//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
}
