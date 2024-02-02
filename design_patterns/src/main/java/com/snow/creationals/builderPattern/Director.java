package com.snow.creationals.builderPattern;

import com.snow.creationals.builderPattern.contructors.IBuilder;
import com.snow.creationals.builderPattern.models.Engine;

public class Director {
    IBuilder builder;

    public Director(IBuilder builder) {
        changeBuilder(builder);
    }

    public void changeBuilder(IBuilder builder) {
        this.builder = builder;
    }

    public void constructSportsCar() {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine(new Engine());
        builder.setTripComputer(true);
        builder.setGPS(true);
        builder.setWindows(2);
    }

    public void constructSUV() {
        builder.reset();
        builder.setSeats(4);
        builder.setEngine(new Engine());
        builder.setTripComputer(true);
        builder.setGPS(true);
        builder.setWindows(4);
    }
}
