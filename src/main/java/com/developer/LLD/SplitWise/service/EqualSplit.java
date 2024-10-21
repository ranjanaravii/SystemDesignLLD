package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.User;

public class EqualSplit implements SplitType {

    ExpenseGroup expenseGroup;

    public EqualSplit(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }
    @Override
    public double getPart(User user) {

        int totalPeople = expenseGroup.getTotalUserInvolvedForExpense();
        double txAmount = expenseGroup.getTransactionAmount();

        return txAmount/totalPeople;
    }

}
