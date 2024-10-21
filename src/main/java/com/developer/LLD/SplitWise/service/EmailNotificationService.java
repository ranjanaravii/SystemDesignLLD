package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.User;

public class EmailNotificationService implements NotificationService {

    @Override
    public void notifyUser(User user, ExpenseGroup expenseGroup) {
        StringBuilder body = new StringBuilder();
        User giver = expenseGroup.getGiver();
        Double amount = user.getBalances().get(giver);

        if (amount < 0) {
            body.append("you owe ").append(giver).append(" ").append(-1 * amount).append("!");
            System.out.println("Email sent with body: [" + body + " to " + user.getEmail() + " ]");
        } else {
            body.append(giver).append(" owe you ").append(amount).append("!");
            System.out.println("Email sent with body: [" + body + " to " + user.getEmail() + " ]");
        }
    }

}
