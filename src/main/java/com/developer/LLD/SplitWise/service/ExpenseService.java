package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.SplitTypeEnum;
import com.developer.LLD.SplitWise.model.User;

import java.util.HashMap;
import java.util.Set;

public class ExpenseService {
    NotificationService notificationService = new EmailNotificationService();

    public ExpenseService() {}

    public ExpenseGroup createExpenseGroup(User giver, Set<User> takers, double transactionAmount, SplitTypeEnum splitTypeEnum, HashMap<User,Double> userContri) throws Exception {
        ExpenseGroup newExpenseGroup = new ExpenseGroup();
        newExpenseGroup.setTakers(takers);
        newExpenseGroup.setGiver(giver);
        newExpenseGroup.setTransactionAmount(transactionAmount);
        newExpenseGroup.setSplitType(splitTypeEnum);
        newExpenseGroup.setAppropriateValuesForSplitType(userContri);

        return newExpenseGroup;
    }

    public void  updateBalanceForAllUsersInExpenseGroup(ExpenseGroup expenseGroup)
    {
        User giver = expenseGroup.getGiver();
        for (User taker : expenseGroup.getTakers()) {
            try {
                // update taker
                double part = expenseGroup.getSplitType().getPart(taker);
                if(!giver.equals(taker))
                {
                    if(taker.getBalances().containsKey(giver))
                    {
                        double prevAmt = taker.getBalances().get(giver);
                        taker.getBalances().put(giver, prevAmt-part);
                    }else{
                        taker.getBalances().put(giver, -1*part);
                    }


                    // update giver
                    if(giver.getBalances().containsKey(taker))
                    {
                        double prevAmt = giver.getBalances().get(taker);
                        giver.getBalances().put(taker, prevAmt + part);
                    }else{
                        giver.getBalances().put(taker, part);
                    }
                    notificationService.notifyUser(taker, expenseGroup);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
