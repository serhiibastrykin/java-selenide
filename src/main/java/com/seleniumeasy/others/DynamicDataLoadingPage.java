package com.seleniumeasy.others;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DynamicDataLoadingPage extends DemoHomePage {
    private final SelenideElement buttonGetNewUser = $("#save"),
            displayedContent = $("#loading");

    public DynamicDataLoadingPage clickGetNewUser() {
        buttonGetNewUser.click();
        return this;
    }

    public DynamicDataLoadingPage verifyImageIsDisplayed() {
        displayedContent.$(By.tagName("img")).shouldBe(visible);
        return this;
    }

    public void validateDisplayedText(Condition c1, Condition c2) {
        displayedContent.should(c1, c2);
    }
}