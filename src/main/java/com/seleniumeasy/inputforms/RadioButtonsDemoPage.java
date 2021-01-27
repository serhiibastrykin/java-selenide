package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;

public class RadioButtonsDemoPage extends DemoHomePage {
    private final SelenideElement buttonGetValues = $(".panel-body > .btn.btn-default"),
            result = $(".groupradiobutton");

    public RadioButtonsDemoPage selectGender(String gender) {
        String selectedGender = String.format("input[value='%s'][name='gender']", gender);
        $(selectedGender).click();
        return this;
    }

    public RadioButtonsDemoPage selectAgeGroup(String ageGroup) {
        String ageGroupRange = String.format("input[value='%s'][name='ageGroup']", ageGroup);
        $(ageGroupRange).click();
        return this;
    }

    public RadioButtonsDemoPage clickGetValues() {
        buttonGetValues.click();
        return this;
    }

    public void validateDisplayedInformation(Condition c1, Condition c2) {
        result.should(c1, c2);
    }
}