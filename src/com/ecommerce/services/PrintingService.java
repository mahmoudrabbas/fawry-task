package com.ecommerce.services;

import com.ecommerce.abstracts.Shippable;
import com.ecommerce.entities.CartItem;
import com.ecommerce.entities.Product;

import java.util.List;
import java.util.Map;

public class PrintingService {


    public static void printShipment(Map<Product, Integer> shipping, double totalWeight){
        System.out.println("** Shipment notice **");
        shipping.forEach(((product, quantity) ->
                System.out.println(quantity+"x "+product.getName()+"\t "+quantity* ((Shippable)product).getWeight())));
        System.out.println("Total package weight "+(totalWeight/1000)+"Kg\n");

    }

    public static void printCheckoutReceipt(List<CartItem>items, double subtotal, double shipFees, double total){
        System.out.println("** Checkout receipt **");

        items.forEach(item ->
                System.out.println(item.getQuantity()+"x "+item.getProduct().getName()+"\t "+item.getProduct().getPrice() * item.getQuantity()));
        System.out.println("__________________________________________");
        System.out.println("Subtotal \t\t"+subtotal);
        System.out.println("Shipping \t\t"+shipFees);
        System.out.println("Amount \t\t"+total);
    }
}

