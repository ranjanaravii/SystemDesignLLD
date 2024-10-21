package com.developer.LLD.ATM;

public class User {
    Card card;
    UserBankAccount userBankAccount;

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
