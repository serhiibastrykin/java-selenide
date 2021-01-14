package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AjaxFormSubmitPage extends DemoHomePage {
    private final SelenideElement INPUT_NAME = $("#title"),
            INPUT_COMMENT = $("#description"),
            BUTTON_SUBMIT = $("#btn-submit"),
            MESSAGE_DISPLAYED = $("#submit-control");

    public AjaxFormSubmitPage enterName(String name) {
        INPUT_NAME.sendKeys(name);
        return this;
    }

    public AjaxFormSubmitPage enterComment(String comment) {
        INPUT_COMMENT.sendKeys(comment);
        return this;
    }

    public AjaxFormSubmitPage clickSubmitButton() {
        BUTTON_SUBMIT.click();
        return this;
    }

    public void verifyDisplayedMessage(String message) {
        MESSAGE_DISPLAYED.shouldHave(text(message));
    }
}