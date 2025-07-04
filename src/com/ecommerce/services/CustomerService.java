package com.ecommerce.services;

import com.ecommerce.entities.Customer;

public class CustomerService {
    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    public boolean checkBalance(double amount){
        return customer.getBalance()>=amount;
    }

    public void payMoney(double amount){
        this.customer.setBalance(customer.getBalance()-amount);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
