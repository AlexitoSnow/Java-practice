package com.snow.creationals.builderPattern.contructors;

import com.snow.creationals.builderPattern.models.Engine;

public interface IBuilder {
    
    public void reset();

    public void setSeats(int seats);

    public void setEngine(Engine engine);

    public void setTripComputer(boolean tripComputer);

    public void setGPS(boolean gps);

    public void setWindows(int windows);

}
