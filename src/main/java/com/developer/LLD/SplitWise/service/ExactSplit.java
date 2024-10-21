package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.User;

import java.util.Map;

public class ExactSplit implements SplitType {

    ExpenseGroup expenseGroup;

    public ExactSplit(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    @Override
    public double getPart(User user) throws Exception{
        if(getExactSplitSum() != expenseGroup.getTransactionAmount()) {
            throw new Exception("sum of participants not equal to total tx amount");
        }
        return expenseGroup.getExactSplit().get(user);
    }

    private double getExactSplitSum() {
        double givenByUser = 0;
        for (Map.Entry<User,Double> entry: expenseGroup.getExactSplit().entrySet()) {
            givenByUser += entry.getValue();
        }
        return givenByUser;
    }
}
