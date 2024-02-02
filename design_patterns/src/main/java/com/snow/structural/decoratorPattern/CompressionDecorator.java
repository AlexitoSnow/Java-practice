package com.snow.structural.decoratorPattern;

public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Compressing data...");
        super.writeData(data + " (comprimido)");
    }

    @Override
    public String readData() {
        System.out.println("Decompressing data...");
        String data = super.readData();
        return data + " (descomprimido)";
    }
}
