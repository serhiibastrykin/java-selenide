package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;

public class ProgressBarModalPage extends DemoHomePage {
    private final SelenideElement buttonShowSimpleDialog = $(".btn-primary"),
            buttonDialogWithCustomMessage = $(".btn-success"),
            buttonDialogWithCustomSettings = $(".btn-warning"),
            modalDialog = $(".modal h3");

    public ProgressBarModalPage openSimpleDialog() {
        buttonShowSimpleDialog.click();
        return this;
    }

    public ProgressBarModalPage openDialogWithCustomMessage() {
        buttonDialogWithCustomMessage.click();
        return this;
    }

    public ProgressBarModalPage openDialogWithCustomSettings() {
        buttonDialogWithCustomSettings.click();
        return this;
    }

    public void verifySimpleDialog(Condition c) {
        modalDialog.should(c);
    }

    public void verifyDialogWithCustomMessage(Condition c) {
        modalDialog.should(c);
    }

    public void verifyDialogWithCustomSettings(Condition c) {
        modalDialog.should(c);
    }
}