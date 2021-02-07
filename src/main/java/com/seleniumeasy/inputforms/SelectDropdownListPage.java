package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class SelectDropdownListPage extends BasePage {
    private final SelenideElement selectedValue = $("#select-demo"),
            displayedValue = $(".selected-value");

    public SelectDropdownListPage selectDayByName(String day) {
        selectedValue.$$("option").find(value(day)).setSelected(true);
        return this;
    }

    public SelectDropdownListPage selectDayByIndex(int day) {
        selectedValue.$$("option").get(day).setSelected(true);
        return this;
    }

    public void validateDisplayedDay(Condition c) {
        displayedValue.should(c);
    }
}