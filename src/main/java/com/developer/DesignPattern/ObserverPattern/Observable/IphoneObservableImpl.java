package com.developer.DesignPattern.ObserverPattern.Observable;

import com.developer.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{

    private int stockCount;
    public List<NotificationAlertObserver> notificationAlertObservers = new ArrayList<>();
    @Override
    public void addObserver(NotificationAlertObserver observer) {
        notificationAlertObservers.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        notificationAlertObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: notificationAlertObservers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if (this.stockCount == 0) {
            notifyObservers();
        }
        this.stockCount = this.stockCount + stockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
