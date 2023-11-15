package com.snow;

import com.snow.abstractFactoryPattern.creators.ClassicFurniture;
import com.snow.abstractFactoryPattern.creators.IFurniture;
import com.snow.abstractFactoryPattern.creators.ModernFurniture;
import com.snow.builderPattern.Director;
import com.snow.builderPattern.contructors.CarBuilder;
import com.snow.builderPattern.contructors.ManualBuilder;
import com.snow.factoryMethodPattern.creators.AndroidDialogWindow;
import com.snow.factoryMethodPattern.creators.DialogWindow;
import com.snow.factoryMethodPattern.creators.WebDialogWindow;
import com.snow.prototypePattern.Circle;
import com.snow.prototypePattern.Rectangle;
import com.snow.prototypePattern.Shape;
import com.snow.singletonPattern.ConexionBD;

public class Main {
    public static void main(String[] args) {
        showBuilderPattern();
        System.out.println();
        showPrototypePattern();
        System.out.println();
        showFactoryMethodPattern();
        System.out.println();
        showAbstractFactoryPattern();
        System.out.println();
        showSingletonPattern();
    }

    private static void showBuilderPattern() {
        System.out.println("Builder Pattern Example");
        CarBuilder carBuilder = new CarBuilder();
        ManualBuilder manualBuilder = new ManualBuilder();
        Director director = new Director(carBuilder);
        director.constructSportsCar();
        System.out.println(carBuilder.getResult());
        director.constructSUV();
        System.out.println(carBuilder.getResult());
        director.changeBuilder(manualBuilder);
        director.constructSportsCar();
        System.out.println(manualBuilder.getResult());
        director.constructSUV();
        System.out.println(manualBuilder.getResult());
    }

    private static void showPrototypePattern(){
        System.out.println("Prototype Pattern Example");
        System.out.println("Creating a circle");
        Circle circle = new Circle(15);
        circle.setX(10);
        circle.setY(20);
        circle.setColor("Red");
        System.out.println(circle);
        System.out.println("Creating a rectangle");
        Rectangle rectangle = new Rectangle(15, 20);
        rectangle.setX(10);
        rectangle.setY(20);
        rectangle.setColor("Blue");
        System.out.println(rectangle);
        System.out.println("Cloning the circle");
        Shape anotherCircle = circle.clone();
        System.out.println(anotherCircle);
        System.out.println("Cloning the rectangle");
        Shape anotherRectangle = rectangle.clone();
        System.out.println(anotherRectangle);
    }

    private static void showFactoryMethodPattern() {
        System.out.println("Factory Method Pattern Example");
        DialogWindow dialogWindow = new WebDialogWindow();
        dialogWindow.showDialog();
        dialogWindow = new AndroidDialogWindow();
        dialogWindow.showDialog();
    }

    private static void showAbstractFactoryPattern() {
        System.out.println("Abstract Factory Pattern Example");
        IFurniture furniture = new ModernFurniture();
        furniture.deliver();
        furniture = new ClassicFurniture();
        furniture.deliver();
    }

    private static void showSingletonPattern() {
        System.out.println("Singleton Pattern Example");
        ConexionBD conexionBD = ConexionBD.getInstance();
        ConexionBD conexionBD2 = ConexionBD.getInstance();
        System.out.println(conexionBD);
        System.out.println(conexionBD2);
        conexionBD.connect();
    }
}