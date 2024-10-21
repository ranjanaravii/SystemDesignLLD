package com.developer.LLD.ATM;

import com.developer.LLD.ATM.AtmState.AtmState;
import com.developer.LLD.ATM.AtmState.IdleState;

public class WithdrawalState extends AtmState {

    public WithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(Atm atm, Card card, int amount) {
        System.out.println("Cash Withdrawal of " + amount + " is successful");
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setAtmCurrentState(new IdleState());
        System.out.println("Thank you for using our ATM");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
        System.out.println("Card Returned");
    }

}
