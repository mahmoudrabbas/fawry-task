package com.ecommerce;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.Customer;
import com.ecommerce.entities.Product;
import com.ecommerce.products.ScratchCard;
import com.ecommerce.products.Biscuit;
import com.ecommerce.products.Cheese;
import com.ecommerce.products.TV;
import com.ecommerce.services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product tv = new TV("LCD", 3000, 2, 2000);
        Product cheese = new Cheese("cheddar", 200, 4, 200, LocalDate.of(2025,7,5));
        Product biscuit = new Biscuit("Moro", 100, 2,LocalDate.of(2025,7,10));
        Product scratchCard = new ScratchCard("card1", 50, 4);

        Customer customer = new Customer(4000);

        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(biscuit, 2);
        cart.add(scratchCard, 2);


        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);

    }
}