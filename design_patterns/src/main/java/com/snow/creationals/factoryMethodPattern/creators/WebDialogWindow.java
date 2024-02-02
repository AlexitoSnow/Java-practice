package com.snow.creationals.factoryMethodPattern.creators;

import com.snow.creationals.factoryMethodPattern.models.IButton;
import com.snow.creationals.factoryMethodPattern.models.WebButton;

public class WebDialogWindow extends DialogWindow {

    @Override
    public IButton createButton() {
        return new WebButton();
    }

}
