package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class JavascriptAlertsPage extends DemoHomePage {
    private final SelenideElement buttonClickMe = $("button[onclick='myConfirmFunction()']"),
            displayedMessage = $("#confirm-demo"),
            buttonClickForPromptBox = $("button[onclick='myPromptFunction()']"),
            displayedName = $("#prompt-demo");

    public JavascriptAlertsPage clickClickMe() {
        buttonClickMe.click();
        return this;
    }

    public JavascriptAlertsPage confirmAlert() {
        switchTo().alert().accept();
        return this;
    }

    public JavascriptAlertsPage dismissAlert() {
        switchTo().alert().dismiss();
        return this;
    }

    public void validateDisplayedMessage(Condition c) {
        displayedMessage.should(c);
    }

    public JavascriptAlertsPage clickClickForPromptBox() {
        buttonClickForPromptBox.click();
        return this;
    }

    public JavascriptAlertsPage enterName(String name) {
        switchTo().alert().sendKeys(name);
        return this;
    }

    public void validateDisplayedName(Condition c) {
        displayedName.should(c);
    }
}