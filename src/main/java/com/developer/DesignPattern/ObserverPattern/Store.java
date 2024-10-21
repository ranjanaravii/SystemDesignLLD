package com.developer.DesignPattern.ObserverPattern;

import com.developer.DesignPattern.ObserverPattern.Observable.IphoneObservableImpl;
import com.developer.DesignPattern.ObserverPattern.Observable.StocksObservable;
import com.developer.DesignPattern.ObserverPattern.Observer.EmailAlertObserverImpl;
import com.developer.DesignPattern.ObserverPattern.Observer.MobileAlertObserverImpl;
import com.developer.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        System.out.println("Observer Pattern");

        StocksObservable iphoneObservable = getIphoneObservable();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of test case: ");
        int test = scanner.nextInt();
        while (test > 0) {
            System.out.print("Enter stock count: ");
            int stockCount = scanner.nextInt();
            iphoneObservable.setStockCount(stockCount);
            test--;
        }

    }

    private static StocksObservable getIphoneObservable() {
        StocksObservable iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@123", iphoneObservable);
        NotificationAlertObserver observe2 = new EmailAlertObserverImpl("xyz2@123", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("113456779", iphoneObservable);

        iphoneObservable.addObserver(observer1);
        iphoneObservable.addObserver(observe2);
        iphoneObservable.addObserver(observer3);
        return iphoneObservable;
    }
}
