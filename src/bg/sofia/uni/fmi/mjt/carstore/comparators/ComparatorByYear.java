package bg.sofia.uni.fmi.mjt.carstore.comparators;

import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;

public class ComparatorByYear implements Comparator<Car> {
    
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getYear(), car2.getYear()); 
    }
}
