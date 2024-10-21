package com.developer.DesignPattern.ObserverPattern.Observable;

import com.developer.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    void addObserver(NotificationAlertObserver observer);
    void removeObserver(NotificationAlertObserver observer);
    void notifyObservers();
    void setStockCount(int stockCount);
    int getStockCount();
}
