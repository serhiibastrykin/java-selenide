package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxDemoPage extends DemoHomePage {
    private final ElementsCollection CHECKBOXES = $$(".cb1-element");
    private final SelenideElement BUTTON_CHECK_ALL = $("#check1"),
            STATUS_VALUE_OF_THE_BUTTON = $("#isChkd");


    public CheckboxDemoPage checkSeveralCheckboxes() {
        for (int i = 0; i < CHECKBOXES.size()-1.; i++) {
            CHECKBOXES.get(i).setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage checkAllCheckboxes() {
        for (int i = 0; i < CHECKBOXES.size(); i++) {
            CHECKBOXES.get(i).setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage verifyValueOfTheButton(boolean b) {
        STATUS_VALUE_OF_THE_BUTTON.shouldHave(value(String.valueOf(b)));
        return this;
    }

    public void validateNameOfTheButton(String buttonName) {
        BUTTON_CHECK_ALL.shouldHave(value(buttonName));
    }
}