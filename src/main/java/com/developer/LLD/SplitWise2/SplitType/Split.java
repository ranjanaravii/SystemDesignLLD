package com.developer.LLD.SplitWise2.SplitType;


import com.developer.LLD.SplitWise2.model.User;

public abstract class Split {
    protected double amount;
    protected User user;

    public Split(User user) {
        this.user = user;
    }

    public abstract double getAmount();

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }
}
