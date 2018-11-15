package bg.sofia.uni.fmi.mjt.carstore.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.carstore.CarStore;
import bg.sofia.uni.fmi.mjt.carstore.Registration;
import bg.sofia.uni.fmi.mjt.carstore.car.Car;
import bg.sofia.uni.fmi.mjt.carstore.car.OrdinaryCar;
import bg.sofia.uni.fmi.mjt.carstore.car.SportCar;
import bg.sofia.uni.fmi.mjt.carstore.comparators.CustomComparator;
import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.CarNotFoundException;

public class SampleCarStoreTest {

    private static final int CAR_NEW_YEAR = 2006; 
    private static final int CAR_MID_YEAR = 2003;
    private static final int CAR_OLD_YEAR = 2001;

    private static final int CHEAP_CAR_PRICE = 300;
    private static final int EXPENSIVE_CAR_PRICE = 5000;
    private static final int VERY_EXPENSIVE_CAR_PRICE = 8000;

    private CarStore carStore;

    @Before
    public void setup() {
        carStore = new CarStore();
    }

    @Test
    public void testIfGetCarsByModelReturnsCorrectCars() {
        Car one = new OrdinaryCar(Model.AUDI, CAR_NEW_YEAR, EXPENSIVE_CAR_PRICE, EngineType.DIESEL, Region.BURGAS);
        Car two = new OrdinaryCar(Model.BMW, CAR_MID_YEAR, CHEAP_CAR_PRICE, EngineType.ELECTRIC, Region.BURGAS);
        Car three = new OrdinaryCar(Model.AUDI, CAR_OLD_YEAR, VERY_EXPENSIVE_CAR_PRICE, EngineType.GASOLINE, Region.BURGAS);

        carStore.add(one);
        carStore.add(two);
        carStore.add(three);

        Collection<Car> cars = carStore.getCarsByModel(Model.AUDI);

        Car[] expected = { three, one };
        Car[] actual = cars.toArray(new Car[cars.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetCarsWithComparatorInDefaultOrder() {
        Car one = new OrdinaryCar(Model.AUDI, CAR_MID_YEAR, EXPENSIVE_CAR_PRICE, EngineType.DIESEL, Region.BURGAS);
        Car two = new OrdinaryCar(Model.BMW, CAR_NEW_YEAR, VERY_EXPENSIVE_CAR_PRICE, EngineType.ELECTRIC, Region.BURGAS);
        Car three = new OrdinaryCar(Model.AUDI, CAR_OLD_YEAR, CHEAP_CAR_PRICE, EngineType.ELECTRIC, Region.BURGAS);

        carStore.add(one);
        carStore.add(two);
        carStore.add(three);
        Collection<Car> cars = carStore.getCars(new CustomComparator(), false);

        Car[] expected = { three, one, two };
        Car[] actual = cars.toArray(new Car[cars.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindByRegistrationNumber() {
        Car one = new OrdinaryCar(Model.AUDI, CAR_MID_YEAR, EXPENSIVE_CAR_PRICE, EngineType.DIESEL, Region.BURGAS);
        Car two = new OrdinaryCar(Model.BMW, CAR_NEW_YEAR, VERY_EXPENSIVE_CAR_PRICE, EngineType.ELECTRIC, Region.BURGAS);
        carStore.add(one);
        carStore.add(two);

        try { 
            assertEquals(one, carStore.getCarByRegistrationNumber(one.getRegistrationNumber()));
        } catch (CarNotFoundException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    @Test
    public void testGenerateRegNumber() {
        Registration reg = new Registration(Region.SOFIA);
        String registration = reg.toString();
        String expected = "CB1000"; 
        String actual = registration.substring(0, 6);
        assertEquals(expected, actual);
        assertEquals(1000, reg.getRegNumber());
        assertEquals("CB", reg.getPrefix());
    } 
    
    @Test
    public void testSportsCarCreation(){
      Car oneFerrari = new SportCar(Model.FERRARI, 2017, 33333333, EngineType.GASOLINE, Region.VARNA); 
      carStore.add(oneFerrari);
      assertEquals(2017, oneFerrari.getYear());
      assertEquals(EngineType.GASOLINE, oneFerrari.getEngineType());
      assertEquals(33333333, oneFerrari.getPrice());
      try {
          Car car = carStore.getCarByRegistrationNumber(oneFerrari.getRegistrationNumber());
          String reg = car.getRegistrationNumber();
        assertEquals(reg, oneFerrari.getRegistrationNumber());
    } catch (CarNotFoundException e) {
        e.printStackTrace();
    }
      assertEquals(1, carStore.getCarsByModel(oneFerrari.getModel()).size());
      Car twoFerrari = new SportCar(Model.FERRARI, 2000, 11111111, EngineType.DIESEL, Region.GABROVO);
      carStore.add(twoFerrari);
      assertEquals(44444444,carStore.getTotalPriceForCars()); 
      assertEquals(2, carStore.getNumberOfCars()); 
    }  
    
    @Test 
    public void testMultipleCarsFromRegionAdd() {
        int i=0;
        while (i<10) {
            Car car = new SportCar(Model.ALFA_ROMEO, 2005, EXPENSIVE_CAR_PRICE, EngineType.HYBRID, Region.RUSE);
            carStore.add(car);
            i++;
        }
        int allCarsAdded = carStore.getNumberOfCars();
        assertEquals(10, allCarsAdded);
        String model = carStore.getCars().iterator().next().getModel().toString();
        String number = carStore.getCars().iterator().next().getRegistrationNumber().substring(1, 5);
        assertEquals(Model.ALFA_ROMEO.toString(), model);
        System.out.println("number "+ number + " model "+ model);
        assertEquals(new String("1001"), number);  
    }
}  