package com.snow.factoryMethodPattern.creators;

import com.snow.factoryMethodPattern.models.IButton;
import com.snow.factoryMethodPattern.models.WebButton;

public class WebDialogWindow extends DialogWindow {

    @Override
    public IButton createButton() {
        return new WebButton();
    }

}
