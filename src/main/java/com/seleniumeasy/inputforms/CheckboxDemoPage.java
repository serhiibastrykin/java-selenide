package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxDemoPage extends DemoHomePage {
    private final ElementsCollection checkboxes = $$(".cb1-element");
    private final SelenideElement buttonCheckAll = $("#check1"),
            statusValueOfTheButton = $("#isChkd");


    public CheckboxDemoPage checkSeveralCheckboxes() {
        for (int i = 0; i < checkboxes.size()-1.; i++) {
            checkboxes.get(i).setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage checkAllCheckboxes() {
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage verifyValueOfTheButton(boolean b) {
        statusValueOfTheButton.shouldHave(value(String.valueOf(b)));
        return this;
    }

    public void validateNameOfTheButton(String buttonName) {
        buttonCheckAll.shouldHave(value(buttonName));
    }
}