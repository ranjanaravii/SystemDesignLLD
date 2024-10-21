package com.developer.LLD.SplitWise2.SplitType;


import com.developer.LLD.SplitWise2.model.User;

public class PercentSplit extends Split {

    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
