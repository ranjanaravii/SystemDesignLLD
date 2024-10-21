package com.developer.LLD.RestaurantBooking.service;

import com.developer.LLD.RestaurantBooking.Entity.Booking;
import com.developer.LLD.RestaurantBooking.Entity.Restaurant;
import com.developer.LLD.RestaurantBooking.Entity.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private static final int MAX_DAYS_IN_FUTURE = 30;

    public boolean bookTable(User user, Restaurant restaurant, LocalDate date, LocalTime time) {
        if (date.isAfter(LocalDate.now().plusDays(MAX_DAYS_IN_FUTURE))) {
            System.out.println("Bookings only allowed up to " + MAX_DAYS_IN_FUTURE + " days in the future.");
            return false;
        }

        if (restaurant.isSlotAvailable(date, time)) {
            restaurant.bookSlot(date, time);
            Booking booking = new Booking(user, restaurant, date, time);
            bookings.add(booking);
            System.out.println("Booking successful: " + booking);
            return true;
        } else {
            System.out.println("Slot not available for booking.");
            return false;
        }
    }
}

