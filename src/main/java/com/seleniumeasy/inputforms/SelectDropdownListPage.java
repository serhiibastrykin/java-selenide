package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelectDropdownListPage extends DemoHomePage {
    private final SelenideElement dropdownPleaseSelect = $("#select-demo"),
            value = $("#select-demo option[value=\"Friday\"]"),
            selectedValue = $(".selected-value");

    public SelectDropdownListPage clickPleaseSelect() {
        dropdownPleaseSelect.click();
        return this;
    }

    public SelectDropdownListPage selectValue() {
        value.setSelected(true);
        return this;
    }

    public void validateSelectedValue(String day) {
        selectedValue.shouldHave(text(day));
    }
}