package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AjaxFormSubmitPage extends DemoHomePage {
    private final SelenideElement inputName = $("#title"),
            inputComment = $("#description"),
            buttonSubmit = $("#btn-submit"),
            messageDisplayed = $("#submit-control");

    public AjaxFormSubmitPage enterName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public AjaxFormSubmitPage enterComment(String comment) {
        inputComment.sendKeys(comment);
        return this;
    }

    public AjaxFormSubmitPage clickSubmitButton() {
        buttonSubmit.click();
        return this;
    }

    public void verifyDisplayedMessage(String message) {
        messageDisplayed.shouldHave(text(message));
    }
}