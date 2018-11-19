package bg.sofia.uni.fmi.mjt.carstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;
import bg.sofia.uni.fmi.mjt.carstore.comparators.ComparatorByYear;
import bg.sofia.uni.fmi.mjt.carstore.comparators.DefaultComparator;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.CarNotFoundException;

public class CarStore {
    

    public static HashSet<Car> carsRegister = null;
    
    
    
    public CarStore(){
     //   registrationNumbers = new HashSet<Registration>();
        carsRegister = new HashSet<Car>();
        Registration.registrations = new LinkedHashMap<>();
    }
    /** 
     * Adds the specified car in the store. 
     * @return true if the car was added successfully to the store
     */
     public boolean add(Car car) {
         return carsRegister.add(car); //add checks if the value exists
     } 

     /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution (i.e. at least one new car is added to the store)
     */
     public boolean addAll(Collection<Car> cars) { //add checks if the value exists
         return carsRegister.addAll(cars);
     }

     /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
     public boolean remove(Car car) { //remove checks if the value exists  
         return carsRegister.remove(car);
     }

     /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
     public Collection<Car> getCarsByModel(Model model) {
         Comparator<Car> ccy = new ComparatorByYear();
         ArrayList<Car> byModel = new ArrayList<Car>();
         for (Car car : carsRegister){
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
         for (Car car : carsRegister) {
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
         cars.addAll(carsRegister);
         Collections.sort(cars, defaultComparator);
       return cars;
     }
     /**
     * Returns all cars sorted according to the order induced by the specified comparator.
     */
     public Collection<Car> getCars(Comparator<Car> comparator) {
         ArrayList<Car> cars = new ArrayList<Car>();
         cars.addAll(carsRegister);
         Collections.sort(cars, comparator);
       return cars;
     }

     /**
     * Returns all cars sorted according to the given comparator and boolean flag for order.
     * @param isReversed if true the cars should be returned in reversed order
     */
     public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) { //TODO check
         ArrayList<Car> cars = new ArrayList<Car>();
         cars.addAll(carsRegister);
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
       return carsRegister.size();
     }

     /**
     * Returns the total price of all cars in the store.
     */
     public int getTotalPriceForCars() {
         int sum = 0;
         for (Car car : carsRegister) {
             sum += car.getPrice();
         }
       return sum;
     }
}
