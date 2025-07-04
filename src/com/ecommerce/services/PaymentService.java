package com.ecommerce.services;

import com.ecommerce.entities.Customer;

public class PaymentService {
    public static boolean pay(Customer customer, double amount){
        if(customer.getBalance() >= amount){
            customer.deductBalance(amount);
            return true;
        }
        return false;
    }
}
