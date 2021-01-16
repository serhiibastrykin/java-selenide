package com.seleniumeasy.others;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DynamicDataLoadingPage extends DemoHomePage {
    private final SelenideElement buttonGenNewUser = $("#save"),
            displayedContent = $("#loading");

    public DynamicDataLoadingPage clickGenNewUser() {
        buttonGenNewUser.click();
        return this;
    }

    public DynamicDataLoadingPage verifyImageIsDisplayed() {
        displayedContent.$(By.tagName("img")).should(exist);
        return this;
    }

    public void validateDisplayedText(Condition c1, Condition c2) {
        displayedContent.should(c1, c2);
    }
}
