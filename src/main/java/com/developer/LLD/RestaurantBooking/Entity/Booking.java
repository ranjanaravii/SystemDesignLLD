package com.developer.LLD.RestaurantBooking.Entity;


import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private User user;
    private Restaurant restaurant;
    private LocalDate date;
    private LocalTime time;

    public Booking(User user, Restaurant restaurant, LocalDate date, LocalTime time) {
        this.user = user;
        this.restaurant = restaurant;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user.getUsername() +
                ", restaurant=" + restaurant.getName() +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
