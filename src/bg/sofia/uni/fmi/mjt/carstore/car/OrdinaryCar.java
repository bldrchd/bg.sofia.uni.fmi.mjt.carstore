package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.UnavailableNumberException;

public class OrdinaryCar extends Car {

    public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region)
            throws UnavailableNumberException {
        super(model, year, price, engineType, region);
        System.out.println("New Ordinary car with registration: " + reg.toString() + " was created.");
    }
}
