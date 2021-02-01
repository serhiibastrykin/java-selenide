package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AjaxFormSubmitPage extends DemoHomePage {
    private final SelenideElement inputName = $("#title"),
            inputComment = $("#description"),
            buttonSubmit = $("#btn-submit"),
            loadingIcon = $("img[src='LoaderIcon.gif']"),
            messageDisplayed = $("#submit-control");

    public AjaxFormSubmitPage enterName(String name) {
        inputName.setValue(name);
        return this;
    }

    public AjaxFormSubmitPage enterComment(String comment) {
        inputComment.setValue(comment);
        return this;
    }

    public AjaxFormSubmitPage clickSubmitButton() {
        buttonSubmit.click();
        return this;
    }

    public AjaxFormSubmitPage verifyLoadingIconIsDisplayed() {
        loadingIcon.shouldBe(visible);
        return this;
    }

    public void validateDisplayedMessage(Condition c) {
        messageDisplayed.waitUntil(c, 6000, 500);
    }
}