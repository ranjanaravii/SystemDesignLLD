package com.developer.LLD.ATM.AtmState;

import com.developer.LLD.ATM.Atm;
import com.developer.LLD.ATM.Card;

public class IdleState extends AtmState {

    @Override
    public void insertCard(Atm atm, Card card){
        System.out.println("Card is inserted");
        atm.setAtmCurrentState(new HasCardState());
    }
}
