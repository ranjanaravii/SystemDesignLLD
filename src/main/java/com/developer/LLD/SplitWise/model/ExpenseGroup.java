package com.developer.LLD.SplitWise.model;

import com.developer.LLD.SplitWise.service.EqualSplit;
import com.developer.LLD.SplitWise.service.ExactSplit;
import com.developer.LLD.SplitWise.service.PercentSplit;
import com.developer.LLD.SplitWise.service.SplitType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ExpenseGroup {
    private String expenseGroupId;
    private double transactionAmount;
    private User giver;
    private Set<User> takers;
    private SplitType splitType;

    private HashMap<User,Double> exactSplit;
    private HashMap<User,Integer> percentSplit;

    public ExpenseGroup() {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.exactSplit = new HashMap<>();
        this.percentSplit = new HashMap<>();
    }

    public ExpenseGroup(double transactionAmount, User giver, Set<User> takers, SplitType splitType) {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.transactionAmount = transactionAmount;
        this.giver = giver;
        this.takers = takers;
        this.splitType = splitType;
    }

    public String getExpenseGroupId() {
        return expenseGroupId;
    }

    public void setExpenseGroupId(String expenseGroupId) {
        this.expenseGroupId = expenseGroupId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public User getGiver() {
        return giver;
    }

    public void setGiver(User giver) {
        this.giver = giver;
    }

    public Set<User> getTakers() {
        return takers;
    }

    public void setTakers(Set<User> takers) {
        this.takers = takers;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitTypeEnum splitTypeEnum) {
        if (splitTypeEnum == SplitTypeEnum.EQUAL) {
            this.splitType = new EqualSplit(this);
        } else if (splitTypeEnum == SplitTypeEnum.EXACT) {
            this.splitType = new ExactSplit(this);
        } else if (splitTypeEnum == SplitTypeEnum.PERCENT) {
            this.splitType = new PercentSplit(this);
        }else {
           throw new IllegalArgumentException("Invalid Split Type");
        }
    }


    public void setAppropriateValuesForSplitType(HashMap<User,Double> userContri ) throws Exception {
        if(this.splitType == null) {
            throw new Exception("set splittype before setting values for users");
        }
        if(this.splitType instanceof EqualSplit && userContri == null) {
            return;
        }
        int takerCount = this.getTotalUserInvolvedForExpense();
        if(userContri.size() != takerCount) {
            throw new Exception("all users contri not provided");
        }
        for (Map.Entry<User,Double> userContriPair : userContri.entrySet()) {
            User contriUser = userContriPair.getKey();
            Double contriUserContribution = userContriPair.getValue();
            if(!this.getTakers().contains(userContriPair.getKey())) {
                throw new Exception("given user not part of this expense group");
            }
            if(this.splitType instanceof PercentSplit) {
                this.getPercentSplit().put(contriUser, contriUserContribution.intValue());
            }else if(this.splitType instanceof ExactSplit) {
                this.getExactSplit().put(contriUser, contriUserContribution);
            }
        }
    }

    public HashMap<User, Double> getExactSplit() {
        return exactSplit;
    }

    public void setExactSplit(HashMap<User, Double> exactSplit) {
        this.exactSplit = exactSplit;
    }

    public HashMap<User, Integer> getPercentSplit() {
        return percentSplit;
    }

    public void setPercentSplit(HashMap<User, Integer> percentSplit) {
        this.percentSplit = percentSplit;
    }

    public int getTotalUserInvolvedForExpense() {
        return takers.size();
    }

}
