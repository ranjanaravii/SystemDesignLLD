package com.developer.LLD.RestaurantBooking.Entity;

public class User {

    private Integer userId;
    private String username;
    private String email;
    private String phone;

    public User(Integer userId, String username, String email, String phone) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
