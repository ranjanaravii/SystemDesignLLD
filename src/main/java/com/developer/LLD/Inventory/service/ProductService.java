package com.developer.LLD.Inventory.service;

import com.developer.LLD.Inventory.entity.Product;
import com.developer.LLD.Inventory.exceptions.ProductNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductService {
    private List<Product> products;
    private Map<String, Product> productsMap;

    public ProductService() {
        this.products = new ArrayList<>();
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.productsMap.putIfAbsent(product.getProductId(), product);
    }

    public void removeProduct(String productId) {
        if (this.productsMap.containsKey(productId)) {
            Product product = this.productsMap.get(productId);
            product.setQuantity(0);
           this.productsMap.put(productId, product);
           return;
        }
        throw new ProductNotFound("Product not found");
    }

    public Map<String, Product> getProductsMap() {
        return productsMap;
    }

    public List<Product> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "ProductService{" +
                "products=" + products +
                ", productsMap=" + productsMap +
                '}';
    }
}
