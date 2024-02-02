package com.snow.creationals.abstractFactoryPattern.creators;

import com.snow.creationals.abstractFactoryPattern.models.chairFamily.IChair;
import com.snow.creationals.abstractFactoryPattern.models.chairFamily.ModernChair;
import com.snow.creationals.abstractFactoryPattern.models.sofaFamily.ISofa;
import com.snow.creationals.abstractFactoryPattern.models.sofaFamily.ModernSofa;
import com.snow.creationals.abstractFactoryPattern.models.tableFamily.ITable;
import com.snow.creationals.abstractFactoryPattern.models.tableFamily.ModernTable;

public class ModernFurniture implements IFurniture {

    @Override
    public IChair createChair() {
        return new ModernChair();
    }

    @Override
    public ITable createTable() {
        return new ModernTable();
    }

    @Override
    public ISofa createSofa() {
        return new ModernSofa();
    }

}
