package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.Registration;
import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;

public class OrdinaryCar extends Car {

    public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region) {

        setModel(model);
        setYear(year);
        setPrice(price);
        setEngineType(engineType);
        setRegion(region);
        reg = new Registration(region);
        setRegistrationNumber(reg.toString());
        System.out.println("New Ordinary car with registration: " + reg.toString() + " was created.");
    }
}
