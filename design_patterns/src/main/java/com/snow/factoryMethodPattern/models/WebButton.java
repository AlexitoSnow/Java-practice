package com.snow.factoryMethodPattern.models;

public class WebButton implements IButton {

    @Override
    public void showDialog() {
        System.out.println("Web Button");
    }

}
