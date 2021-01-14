package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonsDemoPage extends DemoHomePage {
    private final SelenideElement GENDER_MALE = $x("//input[@value='Male' and @name='gender']"),
            AGE_GROUP_RANGE = $x("//input[@value='15 - 50' and @name='ageGroup']"),
            BUTTON_GET_VALUES = $(".panel-body > .btn.btn-default"),
            RESULT = $(".groupradiobutton");

    public RadioButtonsDemoPage selectGender() {
        GENDER_MALE.click();
        return this;
    }

    public RadioButtonsDemoPage selectAgeGroup() {
        AGE_GROUP_RANGE.click();
        return this;
    }

    public RadioButtonsDemoPage clickGetValues() {
        BUTTON_GET_VALUES.click();
        return this;
    }

    public void validateDisplayedInformation(String gender, String ageGroup) {
        RESULT.shouldHave(text(gender), text(ageGroup));
    }
}