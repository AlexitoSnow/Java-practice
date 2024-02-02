package com.snow.structural.decoratorPattern;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // 1. Encripta los datos pasados.
        // 2. Pasa los datos encriptados al método writeData
        super.writeData(data + " (encriptado)");
        // (escribirDatos) del objeto envuelto.
    }

    @Override
    public String readData() {
        // 1. Obtiene datos del método readData (leerDatos) del
        // objeto envuelto.
        String data = super.readData();
        // 2. Intenta descifrarlo si está encriptado.
        // 3. Devuelve el resultado.
        return data + " (descifrado)";
    }
    
}
