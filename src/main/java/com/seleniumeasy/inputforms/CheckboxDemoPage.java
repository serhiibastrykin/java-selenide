package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxDemoPage extends BasePage {
    private final ElementsCollection checkboxes = $$(".cb1-element");
    private final SelenideElement buttonCheckAll = $("#check1"),
            statusValueOfTheButton = $("#isChkd");


    public CheckboxDemoPage checkSeveralCheckboxes() {
        for (int i = 0; i < checkboxes.size()-1.; i++) {
            checkboxes.get(i).scrollTo().setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage checkAllCheckboxes() {
        for (SelenideElement checkbox : checkboxes) {
            checkbox.scrollTo().setSelected(true);
        }
        return this;
    }

    public CheckboxDemoPage verifyValueOfTheButton(String val) {
        statusValueOfTheButton.shouldHave(value(val));
        return this;
    }

    public void validateNameOfTheButton(String buttonName) {
        buttonCheckAll.shouldHave(value(buttonName));
    }
}