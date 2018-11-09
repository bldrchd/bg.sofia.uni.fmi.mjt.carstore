package bg.sofia.uni.fmi.mjt.carstore.comparators;

import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;

public class ComparatorByModel implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getModel().compareTo(car2.getModel());
    }
    

}
