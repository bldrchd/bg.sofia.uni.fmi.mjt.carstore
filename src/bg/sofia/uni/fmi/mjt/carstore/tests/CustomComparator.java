package bg.sofia.uni.fmi.mjt.carstore.tests;

import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;

public class CustomComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		return Integer.compare(car1.getPrice(), car2.getPrice());
	}
	
	public int compareByYear(Car car1, Car car2) {
	    return Integer.compare(car1.getYear(), car2.getYear());
	}
	
	public boolean compareByModel(Car car1, Car car2) {
	    return car1.getModel().equals(car2.getModel());
	}

}