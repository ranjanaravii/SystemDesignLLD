package com.developer.LLD.SplitWise2.model;

import com.developer.LLD.SplitWise2.SplitType.Split;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private final String id;
    private final double amount;
    private final User paidBy;
    private final String description;
    private final List<Split> splits;

    public Expense(String expenseId, double amount, User paidBy, String description) {
        this.id = expenseId;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = new ArrayList<>();
        this.description = description;
    }

    public void addSplit(Split split) {
        splits.add(split);
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
