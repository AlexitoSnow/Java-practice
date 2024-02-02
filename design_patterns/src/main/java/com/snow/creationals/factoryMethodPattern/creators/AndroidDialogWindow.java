package com.snow.creationals.factoryMethodPattern.creators;

import com.snow.creationals.factoryMethodPattern.models.AndroidButton;
import com.snow.creationals.factoryMethodPattern.models.IButton;

public class AndroidDialogWindow extends DialogWindow {

    @Override
    public IButton createButton() {
        return new AndroidButton();
    }

}
