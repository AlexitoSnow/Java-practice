package com.snow.structural.decoratorPattern;

public interface DataSource {
    void writeData(String data);
    String readData();
}
