package com.developer.LLD.Inventory;

import com.developer.LLD.Inventory.entity.Product;
import com.developer.LLD.Inventory.exceptions.ProductNotFound;
import com.developer.LLD.Inventory.service.InventoryService;
import com.developer.LLD.Inventory.service.ProductService;

public class InventoryMainService {

    public static void main(String[] args) {
        Product product1 = new Product("1", "Apple", "FNV", 100, 10);
        Product product2 = new Product("2", "Banana", "FNV", 10, 20);
        Product product3 = new Product("3", "milk", "DAIRY", 27, 5);

        ProductService productService = new ProductService();
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);

        System.out.println("Initial Inventory status: " + productService.getProducts());
        InventoryService inventoryService = new InventoryService(productService);

        System.out.println("Current status of apple: "+ productService.getProductsMap().get("1").getQuantity());
        System.out.println("Removing apple from inventory");
        inventoryService.removeInventory("1");
        try {
            System.out.println("New status of apple: "+ productService.getProductsMap().get("1").getQuantity());
        } catch (ProductNotFound e) {
            System.out.println("Apple removed from inventory");
        }
        System.out.println("Adding more quantity of apple");
        inventoryService.addInventory("1", 20);
        System.out.println("New status of apple: "+ productService.getProductsMap().get("1").getQuantity());
    }
}
