package com.developer.LLD.ATM;

public class UserBankAccount {
    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = this.balance + balance;
    }
}
