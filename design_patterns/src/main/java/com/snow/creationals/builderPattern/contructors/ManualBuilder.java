package com.snow.creationals.builderPattern.contructors;

import com.snow.creationals.builderPattern.models.Engine;
import com.snow.creationals.builderPattern.models.Manual;

public class ManualBuilder implements IBuilder {

    Manual manual;

    @Override
    public void reset() {
        manual = new Manual();
    }

    @Override
    public void setSeats(int seats) {
        manual.setSeats(seats);
    }

    @Override
    public void setEngine(Engine engine) {
        manual.setEngine(engine);
    }

    @Override
    public void setTripComputer(boolean tripComputer) {
        manual.setTripComputer(tripComputer);
    }

    @Override
    public void setGPS(boolean gps) {
        manual.setGps(gps);
    }

    @Override
    public void setWindows(int windows) {
        manual.setWindows(windows);
    }

    public Manual getResult() {
        return manual;
    }
    
}
