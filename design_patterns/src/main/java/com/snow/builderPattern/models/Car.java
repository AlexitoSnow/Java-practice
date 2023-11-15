package com.snow.builderPattern.models;

public class Car {
    private Engine engine;
    private int seats;
    private boolean tripComputer;
    private boolean gps;
    private int windows;
    
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public boolean isTripComputer() {
        return tripComputer;
    }
    public void setTripComputer(boolean tripComputer) {
        this.tripComputer = tripComputer;
    }
    public boolean isGps() {
        return gps;
    }
    public void setGps(boolean gps) {
        this.gps = gps;
    }
    public int getWindows() {
        return windows;
    }
    public void setWindows(int windows) {
        this.windows = windows;
    }

    
}
