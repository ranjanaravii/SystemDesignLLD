package com.developer.LLD.DigitalWallet.model;

import java.util.Date;

public class Transaction {

    private int from;
    private int to;
    private double amount;
    private Date date;

    public Transaction(int from, int to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = new Date();
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction [from=" + from + ", to=" + to + ", amount=" + amount + ", date=" + date + "]";
    }
}
