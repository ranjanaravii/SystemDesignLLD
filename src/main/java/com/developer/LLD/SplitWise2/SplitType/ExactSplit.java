package com.developer.LLD.SplitWise2.SplitType;


import com.developer.LLD.SplitWise2.model.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
