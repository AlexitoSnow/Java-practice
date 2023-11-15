package com.snow.abstractFactoryPattern.creators;

import com.snow.abstractFactoryPattern.models.chairFamily.ClassicChair;
import com.snow.abstractFactoryPattern.models.chairFamily.IChair;
import com.snow.abstractFactoryPattern.models.sofaFamily.ClassicSofa;
import com.snow.abstractFactoryPattern.models.sofaFamily.ISofa;
import com.snow.abstractFactoryPattern.models.tableFamily.ClassicTable;
import com.snow.abstractFactoryPattern.models.tableFamily.ITable;

public class ClassicFurniture implements IFurniture {

    @Override
    public IChair createChair() {
        return new ClassicChair();
    }

    @Override
    public ITable createTable() {
        return new ClassicTable();
    }

    @Override
    public ISofa createSofa() {
        return new ClassicSofa();
    }

}
