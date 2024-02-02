package com.snow.structural.compositePattern;

public class CircleDot extends Dot {
    private int radius;

    public CircleDot(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: " + x + ", " + y + ", " + radius);
    }
    
}
