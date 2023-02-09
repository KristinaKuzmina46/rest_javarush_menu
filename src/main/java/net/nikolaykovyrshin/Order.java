package net.nikolaykovyrshin;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (dishes.size() == 0) return result.toString();
        result.append("Your order: [").append(dishes.get(0));

        for (int i = 1; i < dishes.size(); i++) {
            result.append(", ").append(dishes.get(i).name());
        }
        result.append("] of ").append(tablet);
        return result.toString();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }
}
