package com.developer.LLD.ATM;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;
    static int PIN_NUMBER = 1234;
    private UserBankAccount bankAccount;

    public int getCardNumber() {
        return cardNumber;
    }

    public boolean isPinCorrect(int pin) {
        return pin == PIN_NUMBER;
    }

    public void deductBalance(int amount) {
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(UserBankAccount account) {
        this.bankAccount = account;
    }

    public int getBankBalance() {
       return this.bankAccount.getBalance();
    }
}
