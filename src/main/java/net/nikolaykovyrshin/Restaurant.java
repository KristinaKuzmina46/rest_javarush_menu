package net.nikolaykovyrshin;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        cook.addObserver(waiter);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}