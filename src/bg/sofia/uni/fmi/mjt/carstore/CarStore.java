package bg.sofia.uni.fmi.mjt.carstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;
import bg.sofia.uni.fmi.mjt.carstore.comparators.ComparatorByYear;
import bg.sofia.uni.fmi.mjt.carstore.comparators.DefaultComparator;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.CarNotFoundException;

public class CarStore {
    
    public static HashSet<Registration> registrationNumbers = null;
    public static HashSet<Car> carsStore = null;
    
    
    public CarStore(){
        registrationNumbers = new HashSet<Registration>();
        carsStore = new HashSet<Car>();
    
    }

    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
     public boolean add(Car car) {
         return carsStore.add(car);
     }

     /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution (i.e. at least one new car is added to the store)
     */
     public boolean addAll(Collection<Car> cars) {
         return carsStore.addAll(cars);
     }

     /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
     public boolean remove(Car car) {
         return carsStore.remove(car);
     }

     /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
     public Collection<Car> getCarsByModel(Model model) {
         Comparator<Car> ccy = new ComparatorByYear();
         ArrayList<Car> byModel = new ArrayList<Car>();
         for (Car car : carsStore){
            if (car.getModel().equals(model)) {
                byModel.add(car);
            }
         }
         Collections.sort(byModel, ccy);
         return byModel;
     }

     /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this registration number is not found in the store
     **/
     public Car getCarByRegistrationNumber(String registrationNumber) throws CarNotFoundException {
         for (Car car : carsStore) {
             if (car.getRegistrationNumber().equals(registrationNumber))
                 return car;
         }
         throw new CarNotFoundException();
    }

      /**
      * Returns all cars sorted by their default order*
      **/
     public Collection<Car> getCars() {
         Comparator<Car> defaultComparator = new DefaultComparator();
         ArrayList<Car> cars = new ArrayList<Car>();
         cars.addAll(carsStore);
         Collections.sort(cars, defaultComparator);
       return cars;
     }
     /**
     * Returns all cars sorted according to the order induced by the specified comparator.
     */
     public Collection<Car> getCars(Comparator<Car> comparator) {
         ArrayList<Car> cars = new ArrayList<Car>();
         cars.addAll(carsStore);
         Collections.sort(cars, comparator);
       return cars;
     }

     /**
     * Returns all cars sorted according to the given comparator and boolean flag for order.
     * @param isReversed if true the cars should be returned in reversed order
     */
     public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) { //TODO check
         ArrayList<Car> cars = new ArrayList<Car>();
         cars.addAll(carsStore);
         Collections.sort(cars, comparator);
         if (isReversed) {
             Collections.sort(cars, Collections.reverseOrder());
             return cars;
         }
         return cars;
     }

     /**
     * Returns the total number of cars in the store.
     */
     public int getNumberOfCars() {
       return carsStore.size();
     }

     /**
     * Returns the total price of all cars in the store.
     */
     public int getTotalPriceForCars() {
         int sum = 0;
         for (Car car : carsStore) {
             sum += car.getPrice();
         }
       return sum;
     }
}
