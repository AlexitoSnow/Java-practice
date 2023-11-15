package com.snow.factoryMethodPattern.creators;

import com.snow.factoryMethodPattern.models.AndroidButton;
import com.snow.factoryMethodPattern.models.IButton;

public class AndroidDialogWindow extends DialogWindow {

    @Override
    public IButton createButton() {
        return new AndroidButton();
    }

}
