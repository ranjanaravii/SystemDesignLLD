package com.developer.LLD.SplitWise2.SplitType;


import com.developer.LLD.SplitWise2.model.User;

public class EqualSplit extends Split {

    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
