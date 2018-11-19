package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.Registration;
import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.UnavailableNumberException;

public abstract class Car {

    protected Model model = null;
    protected int year = 0;
    protected int price = 0;
    protected EngineType engineType = null;
    protected Region region = null;
    protected String registrationNum = null;
    protected Registration reg = null;
    
    public Car(Model model, int year, int price, EngineType engineType, Region region) throws UnavailableNumberException{
        setModel(model);
        setYear(year);
        setPrice(price);
        setEngineType(engineType);
        setRegion(region);
        reg = new Registration(region);
        setRegistration(reg);
        setRegistrationNumber(reg.toString());
    }

    /**
     * Returns the model of the car.
     */
    public Model getModel() {
        return this.model;
    }

    @Override
    public int hashCode() {
        return registrationNum.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().isInstance(this))
            return false;
        Car c = (Car) obj;
        if (this.model.equals(c.getModel()) && this.year == c.getYear() && this.region.equals(c.getRegion())
                && this.engineType.equals(c.getEngineType()) && this.price == c.getPrice()
                && this.registrationNum.equals(c.getRegistrationNumber()))
            return super.equals(obj);
        return false;
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
    private void setRegistration(Registration reg) {
        this.reg = reg; 
    }
    
    public Registration getRegistration(){
        return this.reg;
    }
}