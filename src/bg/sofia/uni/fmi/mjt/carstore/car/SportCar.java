package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.CarStore;
import bg.sofia.uni.fmi.mjt.carstore.Registration;
import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;

public class SportCar implements Car {
    private Model model =null;
    private int year = 0;
    private int price = 0;
    private EngineType engineType=null;
    private Region region=null;
    private String registrationNum = null;
    private Registration reg = null;
    
    public SportCar(Model model, int year, int price, EngineType engineType, Region region) {
        setModel(model);
        setYear(year);
        setPrice(price); 
        setEngineType(engineType);
        setRegion(region);
        reg = new Registration(region);
        setRegistrationNumber(reg.toString()); 
        System.out.println("New Sports car with registration: " + reg.toString() + " was created.");
        CarStore.registrationNumbers.add(reg);
    }
    @Override
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Model getModel() {
        return this.model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public EngineType getEngineType() {
        return this.engineType;
    }
    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
    @Override
    public String getRegistrationNumber() {
        return registrationNum ;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNum = registrationNumber;
    }
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }
}
