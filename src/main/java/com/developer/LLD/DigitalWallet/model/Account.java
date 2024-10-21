package com.developer.LLD.DigitalWallet.model;

import com.developer.LLD.DigitalWallet.Utility.AccountNumberGenerator;

import java.util.Set;
import java.util.TreeSet;

public class Account {
    private int accountNumber;
    private User user;
    private double balance;
    private Set<Transaction> transactions;

    public Account(String name, String email, String phoneNumber, double amount) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.user = new User(name, email, phoneNumber);
        this.balance = amount;
        this.transactions = new TreeSet<>((a, b) -> a.getDate().compareTo(b.getDate()));
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(TreeSet<Transaction> transactions) {
        this.transactions = transactions;
    }
}
