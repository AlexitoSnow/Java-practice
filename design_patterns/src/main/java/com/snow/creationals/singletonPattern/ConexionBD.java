package com.snow.creationals.singletonPattern;

public class ConexionBD {
    private static ConexionBD instance;

    private String host;
    private String port;
    private String user;
    private String password;

    private ConexionBD() {
        host = "localhost";
        port = "3306";
        user = "admin";
        password = "admin";
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to " + host + ":" + port + " with user " + user + " and password " + password);
    }
    
}
