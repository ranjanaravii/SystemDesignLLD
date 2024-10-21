package com.developer.DesignPattern.ObserverPattern.Observer;

import com.developer.DesignPattern.ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String email;
    StocksObservable stocksObservable;
    public EmailAlertObserverImpl(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;
    }
    @Override
    public void update() {
        System.out.println("Email alert send to: " + email + "Stock has been updated");
    }
}
