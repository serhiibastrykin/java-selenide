package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class JavascriptAlertsPage extends DemoHomePage {
    private final SelenideElement buttonClickMe = $("button[onclick='myConfirmFunction()']"),
            displayedMessage = $("#confirm-demo");

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

    public void validateDisplayedMessage(String message) {
        displayedMessage.shouldHave(exactText(message));
    }
}