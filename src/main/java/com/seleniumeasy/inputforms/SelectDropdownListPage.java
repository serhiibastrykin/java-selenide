package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelectDropdownListPage extends DemoHomePage {
    private final SelenideElement DROPDOWN_PLEASE_SELECT = $("#select-demo"),
            VALUE = $("#select-demo option[value=\"Friday\"]"),
            SELECTED_VALUE = $(".selected-value");

    public SelectDropdownListPage clickPleaseSelect() {
        DROPDOWN_PLEASE_SELECT.click();
        return this;
    }

    public SelectDropdownListPage selectValue() {
        VALUE.setSelected(true);
        return this;
    }

    public void validateSelectedValue(String day) {
        SELECTED_VALUE.shouldHave(text(day));
    }
}