package com.developer.LLD.RestaurantBooking.service;

import com.developer.LLD.RestaurantBooking.Entity.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantService {
    private Map<String, Restaurant> restaurants = new HashMap<>();

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public List<Restaurant> searchRestaurant(String city, String area, String cuisine, Boolean isVeg, Integer maxCost) {
        return restaurants.values().stream()
                .filter(r -> (city == null || r.getCity().equalsIgnoreCase(city)) &&
                        (area == null || r.getArea().equalsIgnoreCase(area)) &&
                        (cuisine == null || r.getCuisine().equalsIgnoreCase(cuisine)) &&
                        (isVeg == null || r.isVeg() == isVeg) &&
                        (maxCost == null || r.getCostForTwo() <= maxCost))
                .collect(Collectors.toList());
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurants.get(name);
    }
}