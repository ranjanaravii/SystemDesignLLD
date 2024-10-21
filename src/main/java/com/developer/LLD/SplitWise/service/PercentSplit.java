package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.User;

import java.util.Map;

public class PercentSplit implements SplitType {
    ExpenseGroup expenseGroup;

    public PercentSplit(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    @Override
    public double getPart(User user) throws Exception {
        if(!isPercentSplitSumEqualTo100()) {
            throw new Exception("total sum of percent does not equal to 100");
        }
        return expenseGroup.getTransactionAmount()*expenseGroup.getPercentSplit().get(user)/100;
    }

    private boolean isPercentSplitSumEqualTo100() {
        int total = 0;
        for (Map.Entry<User,Integer> entry : expenseGroup.getPercentSplit().entrySet()) {
            total += entry.getValue();
        }
        return total == 100;
    }
}
