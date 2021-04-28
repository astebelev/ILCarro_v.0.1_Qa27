package models;

public class Car {
    String location;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wd;
    String doors;
    String seats;
    String carClass;
    String fuelConsumption;
    String carRegNum;
    String price;
    String distanceIncluded;


    public Car withLocation(String location) {
        this.location = location;
        return this;
    }

    public Car withMake(String make) {
        this.make = make;
        return this;
    }

    public Car withModel(String model) {
        this.model = model;
        return this;
    }

    public Car withYear(String year) {
        this.year = year;
        return this;
    }

    public Car withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car withGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car withWd(String wd) {
        this.wd = wd;
        return this;
    }

    public Car withDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car withSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car withCarClass(String carClass) {
        this.carClass = carClass;
        return this;
    }

    public Car withFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car withCarRegNum(String carRegNum) {
        this.carRegNum = carRegNum;
        return this;
    }

    public Car withPrice(String price) {
        this.price = price;
        return this;
    }

    public Car withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }

    public String getGear() {
        return gear;
    }

    public String getWd() {
        return wd;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }

    public String getCarClass() {
        return carClass;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public String getCarRegNum() {
        return carRegNum;
    }

    public String getPrice() {
        return price;
    }

    public String getDistanceIncluded() {
        return distanceIncluded;
    }


}

