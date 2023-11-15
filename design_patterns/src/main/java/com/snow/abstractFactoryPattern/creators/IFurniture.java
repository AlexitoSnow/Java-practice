package com.snow.abstractFactoryPattern.creators;

import com.snow.abstractFactoryPattern.models.chairFamily.IChair;
import com.snow.abstractFactoryPattern.models.sofaFamily.ISofa;
import com.snow.abstractFactoryPattern.models.tableFamily.ITable;

public interface IFurniture {
    public IChair createChair();
    public ITable createTable();
    public ISofa createSofa();

    public default void deliver() {
        System.out.println("Delivering furniture...");
        System.out.println(createChair());
        System.out.println(createTable());
        System.out.println(createSofa());
    }
}
