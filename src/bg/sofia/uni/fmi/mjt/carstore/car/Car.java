package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.Registration;
import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;

public abstract class Car {

    protected Model model = null;
    protected int year = 0;
    protected int price = 0;
    protected EngineType engineType = null;
    protected Region region = null;
    protected String registrationNum = null;
    protected Registration reg = null;

    /**
     * Returns the model of the car.
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Returns the price of the car.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType() {
        return this.engineType;
    }

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber() {
        return registrationNum;
    }

    /**
     * Returns a region for the construction of the car.
     */
    public Region getRegion() {
        return region;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setModel(Model model) {
        this.model = model;
    }

    void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    void setRegistrationNumber(String registrationNumber) {
        this.registrationNum = registrationNumber;
    }

    void setRegion(Region region) {
        this.region = region;
    }
}