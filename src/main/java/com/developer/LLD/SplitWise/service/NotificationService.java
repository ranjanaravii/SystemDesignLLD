package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.ExpenseGroup;
import com.developer.LLD.SplitWise.model.User;

public interface NotificationService {
    void notifyUser(User user, ExpenseGroup expenseGroup);
}