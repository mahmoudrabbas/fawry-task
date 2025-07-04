package com.ecommerce.services;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.CartItem;
import com.ecommerce.entities.Customer;
import com.ecommerce.entities.Product;
import com.ecommerce.abstracts.Expirable;
import com.ecommerce.abstracts.Shippable;


public class CheckoutService {
    private final ShippingService shippingService;
    double SHIPPING_COST_PER_ONE_KILO = 30;

    public CheckoutService() {
        shippingService = new ShippingService();
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is Empty");
            return;
        }

        double subtotal = 0;
        double totalWeight = 0;
        var cartItems = cart.getItems();


        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product.checkQuantity(quantity)) {
                subtotal += product.getPrice() * quantity;
                product.reduceQuantity(quantity);
                if (product instanceof Expirable) {
                    if (((Expirable) product).isExpired()) {
                        System.out.println("Error: " + product.getName() + " has expired");
                        return;
                    }
                }

                if (product instanceof Shippable) {
                    shippingService.shipProduct(product, quantity);
                    double productWeight = ((Shippable) product).getWeight();
                    totalWeight += productWeight * quantity;
                }
            } else {
                System.out.println("Error: " + product.getName() + " is out of stock");
                return;
            }
        }

        double shipFees = Math.round(totalWeight / 1000) * SHIPPING_COST_PER_ONE_KILO;
        double total = subtotal + shipFees;

        if (!PaymentService.pay(customer, total)) {
            System.out.println("Error: your balance is insufficient");
        }

        PrintingService.printShipment(shippingService.getShipping(), totalWeight);
        PrintingService.printCheckoutReceipt(cart.getItems(), subtotal, shipFees, total);
        cart.clearCart();

    }

}