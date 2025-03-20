package org.example;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Select language:");
        System.out.println("1. Sweden");
        System.out.println("2. Finnish");
        System.out.println("3. Japanese");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();


        Locale locale;

        switch (choice){
            case 1:
                locale = new Locale("sv", "SE");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Invalid choice");
                locale = new Locale("en", "US");
                break;

        }

        ResourceBundle rb;

        try{
            rb = ResourceBundle.getBundle("messages", locale);
        }catch (Exception e){
            System.out.println("Language not supported");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }


        Scanner input = new Scanner(System.in);


        System.out.print(rb.getString("cartItems"));
        int numberOfItems = input.nextInt();

        for (int i = 0; i <= numberOfItems-1; i++) {
            System.out.print(rb.getString("itemPrice") + " " + (i + 1) + ": ");
            int price = input.nextInt();
            System.out.print(rb.getString("itemQuantity") + " " + (i + 1) + ": ");
            int quantity = input.nextInt();
            cart.addItem(price, quantity);
            System.out.println(price * quantity);
//            System.out.println(cart.getEachTotal());
        }

        double totalCost = cart.getTotal();
//        System.out.printf("The total cost of the shopping cart is: $%.2f%n", totalCost);
        System.out.printf(rb.getString("total") + ": $%.2f", totalCost);
    }
}