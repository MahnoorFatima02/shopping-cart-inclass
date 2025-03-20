package org.example;

import java.util.HashMap;

public class ShoppingCart {
    HashMap<Integer, Integer> cart = new HashMap<>();

    public void addItem(Integer price, int quantity) {
        cart.put(price, quantity);
    }

    public double getTotal() {
        double total = 0;
        for (Integer price : cart.keySet()) {
            total += price * cart.get(price);
        }

        return total;
    }



}
