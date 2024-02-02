package com.snow.creationals.factoryMethodPattern.creators;

import com.snow.creationals.factoryMethodPattern.models.IButton;

public abstract class DialogWindow {

    public void showDialog(){
        IButton button = createButton();
        button.showDialog();
    }

    public abstract IButton createButton();
}
