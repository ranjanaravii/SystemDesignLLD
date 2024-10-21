package com.developer.LLD.ATM.AtmState;

import com.developer.LLD.ATM.Atm;
import com.developer.LLD.ATM.Card;

public class HasCardState extends AtmState {

    public HasCardState() {
        System.out.println("Enter your card pin number");
    }

    @Override
    public void authenticatePin(Atm atm, Card card, int pin){
        boolean isCorrectPinEntered = card.isPinCorrect(pin);

        if(isCorrectPinEntered) {
            atm.setAtmCurrentState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(Atm atm){
        returnCard();
        atm.setAtmCurrentState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }


}
