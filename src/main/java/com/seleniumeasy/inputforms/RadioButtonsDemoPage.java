package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonsDemoPage extends DemoHomePage {
    private final SelenideElement genderMale = $x("//input[@value='Male' and @name='gender']"),
            ageGroupRange = $x("//input[@value='15 - 50' and @name='ageGroup']"),
            buttonGetValues = $(".panel-body > .btn.btn-default"),
            result = $(".groupradiobutton");

    public RadioButtonsDemoPage selectGender() {
        genderMale.click();
        return this;
    }

    public RadioButtonsDemoPage selectAgeGroup() {
        ageGroupRange.click();
        return this;
    }

    public RadioButtonsDemoPage clickGetValues() {
        buttonGetValues.click();
        return this;
    }

    public void validateDisplayedInformation(String gender, String ageGroup) {
        result.shouldHave(text(gender), text(ageGroup));
    }
}