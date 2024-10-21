package com.developer.LLD.RestaurantBooking.Entity;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Restaurant {
    private final String name;
    private final String city;
    private final String area;
    private final String cuisine;
    private final boolean isVeg;
    private final int costForTwo;
    private final Map<LocalDate, Set<LocalTime>> availableSlots;

    public Restaurant(String name, String city, String area, String cuisine, boolean isVeg, int costForTwo) {
        this.name = name;
        this.city = city;
        this.area = area;
        this.cuisine = cuisine;
        this.isVeg = isVeg;
        this.costForTwo = costForTwo;
        this.availableSlots = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getCuisine() {
        return cuisine;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public int getCostForTwo() {
        return costForTwo;
    }

    public Map<LocalDate, Set<LocalTime>> getAvailableSlots() {
        return availableSlots;
    }

    public void addAvailableSlot(LocalDate date, LocalTime time) {
        availableSlots.putIfAbsent(date, new HashSet<>());
        availableSlots.get(date).add(time);
    }

    public boolean isSlotAvailable(LocalDate date, LocalTime time) {
        return availableSlots.containsKey(date) && availableSlots.get(date).contains(time);
    }

    public void bookSlot(LocalDate date, LocalTime time) {
        if (isSlotAvailable(date, time)) {
            availableSlots.get(date).remove(time);
        }
    }
}

