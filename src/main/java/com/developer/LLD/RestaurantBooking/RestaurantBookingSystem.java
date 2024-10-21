package com.developer.LLD.RestaurantBooking;

import com.developer.LLD.RestaurantBooking.Entity.Restaurant;
import com.developer.LLD.RestaurantBooking.Entity.User;
import com.developer.LLD.RestaurantBooking.service.BookingService;
import com.developer.LLD.RestaurantBooking.service.RestaurantService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RestaurantBookingSystem {
    public static  void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        BookingService bookingService = new BookingService();

        // Sample Data
        Restaurant r1 = new Restaurant("SpiceHub", "Bangalore", "Indiranagar", "Indian", true, 500);
        r1.addAvailableSlot(LocalDate.now().plusDays(1), LocalTime.of(19, 0));
        r1.addAvailableSlot(LocalDate.now().plusDays(1), LocalTime.of(20, 0));

        restaurantService.registerRestaurant(r1);

        User user1 = new User("john_doe");

        // Search for restaurants
        List<Restaurant> results = restaurantService.searchRestaurant("Bangalore", "Indiranagar", "Indian", true, 600);
        System.out.println("Search Results: " + results.size() + " restaurants found.");

        // Book a table
        if (!results.isEmpty()) {
            Restaurant selectedRestaurant = results.get(0);
            bookingService.bookTable(user1, selectedRestaurant, LocalDate.now().plusDays(1), LocalTime.of(19, 0));
        }
    }
}