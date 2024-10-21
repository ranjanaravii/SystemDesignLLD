package com.developer.LLD.ATM.AtmState;

import com.developer.LLD.ATM.Atm;
import com.developer.LLD.ATM.Card;
import com.developer.LLD.ATM.TransactionType;

public abstract class AtmState {
    public void insertCard(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(Atm atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }


    public void cashWithdrawal(Atm atm, Card card, int amount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(Atm atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(Atm atm, Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(Atm atm){
        System.out.println("OOPS!! Something went wrong");
    }

}
