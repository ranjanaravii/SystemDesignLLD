package com.developer.DesignPattern.ObserverPattern.Observer;

import com.developer.DesignPattern.ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String mobileNumber;
    StocksObservable stocksObservable;

    public MobileAlertObserverImpl(String mobileNumber, StocksObservable stocksObservable) {
        this.mobileNumber = mobileNumber;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        System.out.println("Mobile alert send to: "+ mobileNumber+ " Stock has been updated");
    }
}
