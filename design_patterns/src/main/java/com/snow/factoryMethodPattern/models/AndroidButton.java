package com.snow.factoryMethodPattern.models;

public class AndroidButton implements IButton {

    @Override
    public void showDialog() {
        System.out.println("Android Button");
    }

}
