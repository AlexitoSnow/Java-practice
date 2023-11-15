package com.snow.builderPattern.contructors;

import com.snow.builderPattern.models.Car;
import com.snow.builderPattern.models.Engine;

public class CarBuilder implements IBuilder {

    Car car;

    @Override
    public void reset() {
        car = new Car();
    }

    @Override
    public void setSeats(int seats) {
        car.setSeats(seats);
    }

    @Override
    public void setEngine(Engine engine) {
        car.setEngine(engine);
    }

    @Override
    public void setTripComputer(boolean tripComputer) {
        car.setTripComputer(tripComputer);
    }

    @Override
    public void setGPS(boolean gps) {
        car.setGps(gps);
    }

    @Override
    public void setWindows(int windows) {
        car.setWindows(windows);
    }

    public Car getResult() {
        return car;
    }
    
}
