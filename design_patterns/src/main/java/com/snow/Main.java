package com.snow;

import java.util.ArrayList;

import com.snow.creationals.abstractFactoryPattern.creators.ClassicFurniture;
import com.snow.creationals.abstractFactoryPattern.creators.IFurniture;
import com.snow.creationals.abstractFactoryPattern.creators.ModernFurniture;
import com.snow.creationals.builderPattern.Director;
import com.snow.creationals.builderPattern.contructors.CarBuilder;
import com.snow.creationals.builderPattern.contructors.ManualBuilder;
import com.snow.creationals.factoryMethodPattern.creators.AndroidDialogWindow;
import com.snow.creationals.factoryMethodPattern.creators.DialogWindow;
import com.snow.creationals.factoryMethodPattern.creators.WebDialogWindow;
import com.snow.creationals.prototypePattern.Circle;
import com.snow.creationals.prototypePattern.Rectangle;
import com.snow.creationals.prototypePattern.Shape;
import com.snow.creationals.singletonPattern.ConexionBD;
import com.snow.structural.adapterPattern.RoundHole;
import com.snow.structural.adapterPattern.RoundPeg;
import com.snow.structural.adapterPattern.SquarePeg;
import com.snow.structural.adapterPattern.SquarePegAdapter;
import com.snow.structural.compositePattern.*;
import com.snow.structural.decoratorPattern.CompressionDecorator;
import com.snow.structural.decoratorPattern.DataSource;
import com.snow.structural.decoratorPattern.EncryptionDecorator;
import com.snow.structural.decoratorPattern.FileDataSource;

public class Main {
    public static void main(String[] args) {
        creationalPatterns();
        structuralPatterns();
    }

    private static void creationalPatterns() {
        System.out.println("Creational Patterns");
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

    private static void structuralPatterns() {
        System.out.println("Structural Patterns");
        showAdapterPattern();
        showFacadePattern();
        showCompositePattern();
        showDecoratorPattern();
    }

    private static void showDecoratorPattern() {
        System.out.println("Decorator Pattern Example");
        DataSource source = new FileDataSource("somefile.dat");
        source.writeData("some data");
        // El archivo objetivo se ha escrito con datos sin
        // formato.
        source = new CompressionDecorator(source);
        source.writeData("some data");
        // El archivo objetivo se ha escrito con datos
        // comprimidos.

        source = new EncryptionDecorator(source);
        // La variable fuente ahora contiene esto:
        // Cifrado > Compresión > FileDataSource
        source.writeData("some data");
        // El archivo se ha escrito con datos comprimidos y
        // encriptados.
    }

    private static void showCompositePattern() {
        System.out.println("Composite Pattern Example");
        CompoundGraphic all = new CompoundGraphic();
        all.add(new CircleDot(1, 2, 3));
        all.add(new Dot(5, 3));
        all.add(new CircleDot(10, 10, 5));

        // Combina componentes seleccionados para formar un
        // componente compuesto complejo.
        CompoundGraphic selected = new CompoundGraphic();
        new ArrayList<Graphic>().forEach(graphic -> {
                selected.add(graphic);
                all.remove(graphic);
        });
        all.add(selected);
        all.draw();
    }

    private static void showFacadePattern() {
        System.out.println("Facade Pattern Example");
    }

    private static void showAdapterPattern() {
        System.out.println("Adapter Pattern Example");
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        System.out.println(hole.fits(rpeg)); // true
        SquarePeg small_sqpeg = new SquarePeg(5);
        SquarePeg large_sqpeg = new SquarePeg(10);
        // hole.fits(small_sqpeg); // esto no compila (tipos incompatibles)
        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);
        System.out.println(hole.fits(small_sqpeg_adapter)); // true
        System.out.println(hole.fits(large_sqpeg_adapter)); // false
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

    private static void showPrototypePattern() {
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