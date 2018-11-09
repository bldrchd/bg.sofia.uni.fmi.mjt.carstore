package bg.sofia.uni.fmi.mjt.carstore.comparators;

import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;

public class DefaultComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        int modelComp = car1.getModel().compareTo(car2.getModel());
        int yearComp = Integer.compare(car1.getYear(), car2.getYear());

        if (modelComp == 0)
            return ((yearComp == 0) ? modelComp : yearComp);
        return modelComp;

    }
}
