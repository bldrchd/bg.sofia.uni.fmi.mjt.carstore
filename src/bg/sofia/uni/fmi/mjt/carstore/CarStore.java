package bg.sofia.uni.fmi.mjt.carstore;

import java.util.Collection;
import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;

public class CarStore {
    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
     public boolean add(Car car) {
       // implement ...
       return false;
     }

     /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution (i.e. at least one new car is added to the store)
     */
     public boolean addAll(Collection<Car> cars) {
       // implement ...
       return false;
     }

     /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
     public boolean remove(Car car) {
       // implement ...
       return false;
     }

     /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
     public Collection<Car> getCarsByModel(Model model) {
       // implement ...
       return null;
     }

     /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this registration number is not found in the store
     **/
     public Car getCarByRegistrationNumber(String registrationNumber) {
       // implement ...
       return null;
     }

      /**
      * Returns all cars sorted by their default order*
      **/
     public Collection<Car> getCars() {
       // implement ...
       return null;
     }
     /**
     * Returns all cars sorted according to the order induced by the specified comparator.
     */
     public Collection<Car> getCars(Comparator<Car> comparator) {
       // implement ...
       return null;
     }

     /**
     * Returns all cars sorted according to the given comparator and boolean flag for order.
     * @param isReversed if true the cars should be returned in reversed order
     */
     public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) {
       // implement
       return null;
     }

     /**
     * Returns the total number of cars in the store.
     */
     public int getNumberOfCars() {
       // implement ...
       return 0;
     }

     /**
     * Returns the total price of all cars in the store.
     */
     public int getTotalPriceForCars() {
       // implement ...
       return 0;
     }
}
