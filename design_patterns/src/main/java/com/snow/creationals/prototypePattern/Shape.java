package com.snow.creationals.prototypePattern;

public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape() {
    }

    protected Shape(Shape source) {
        if (source != null) {
            this.x = source.x;
            this.y = source.y;
            this.color = source.color;
        }
    }

    public abstract Shape clone();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
    return "Shape{" +
            "x=" + x +
            ", y=" + y +
            ", color='" + color + '\'' +
            '}';
    }

}
