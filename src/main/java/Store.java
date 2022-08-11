import interfaces.Buyer;
import interfaces.CreateCar;

import java.util.ArrayList;
import java.util.List;

public class Store implements CreateCar, Buyer {

    int capacity;
    List<String> car = new ArrayList<>();

    Store (int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void makeCar() {
        car.add("New avto complete!");
    }

    @Override
    public void buyCar() {
        car.remove(0);
    }
}
