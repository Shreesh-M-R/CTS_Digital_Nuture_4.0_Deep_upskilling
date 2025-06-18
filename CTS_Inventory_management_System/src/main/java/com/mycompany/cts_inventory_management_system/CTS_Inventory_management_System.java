package com.mycompany.cts_inventory_management_system;

import java.util.ArrayList;
import java.util.Scanner;


class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(id + " - " + name + " - Qty: " + quantity + " - Price: " + price);
    }
}

class InventoryManager {
    ArrayList <Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added successfully");
    }
    
    void updateProduct(int id, int newQuantity, double newPrice) {
        for (Product p : products) { 
            if (p.id == id) {
                p.quantity = newQuantity;
                p.price = newPrice;
                System.out.println("Product updated");
                return;
            }
        }
        System.out.println("The Product not found");
    }

    void deleteProduct(int id) {
        for (Product p : products) {
            if (p.id == id) {
                products.remove(p);
                System.out.println("The Product got deleted");
                return;
            }
        }
        System.out.println("The Product not found");
    }

    void showAll() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty");
        } else {
            System.out.println("Inventory List:");
            for (Product p : products) {
                p.display();
            }
        }
    }
}

public class CTS_Inventory_management_System{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLint();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Product newProduct = new Product(id, name, qty, price);
                    manager.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    manager.updateProduct(updateId, newQty, newPrice);
                    break;
                    
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteProduct(deleteId);
                    break;

                case 4:
                    manager.showAll();
                    break;

                case 5:
                    System.out.println("GoodBye !!!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.Please try again");
            }
        }
    }
}
