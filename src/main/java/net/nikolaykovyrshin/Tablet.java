package net.nikolaykovyrshin;

import net.nikolaykovyrshin.ad.AdvertisementManager;
import net.nikolaykovyrshin.ad.NoVideoAvailableException;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() throws IOException {
        Order order = null;
        try {
            order = new Order(this);
            if (order.isEmpty()) {
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
