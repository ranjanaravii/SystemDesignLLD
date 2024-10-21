package com.developer.LLD.Inventory.service;

public class InventoryService {

    ProductService productService;

    public InventoryService(ProductService productService){
        this.productService = productService;
    }

    public void addInventory(String productId, int quantity) {
        // Add inventory to the product
        productService.getProductsMap()
                .get(productId)
                .setQuantity(productService.getProductsMap().get(productId).getQuantity() + quantity);
    }

    public void removeInventory(String productId) {
        productService.removeProduct(productId);
    }
}
