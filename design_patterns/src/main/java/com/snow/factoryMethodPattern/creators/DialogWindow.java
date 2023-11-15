package com.snow.factoryMethodPattern.creators;

import com.snow.factoryMethodPattern.models.IButton;

public abstract class DialogWindow {

    public void showDialog(){
        IButton button = createButton();
        button.showDialog();
    }

    public abstract IButton createButton();
}
