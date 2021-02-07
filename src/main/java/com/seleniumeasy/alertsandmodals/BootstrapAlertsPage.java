package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.seleniumeasy.waits.CustomWaits.waitUntilAlertMessageDisappears;

public class BootstrapAlertsPage extends BasePage {
    private final ElementsCollection autocloseableAlerts = $$x("//button[contains(text()," +
            " 'Autocloseable')]"),
            normalAlerts = $$x("//button[contains(text(), 'Normal')]"),
            autocloseableMessages = $$x("//div[@class='col-md-6']/div[not(@hidden)]"),
            normalMessages = $$x("//div[@class='col-md-6']/div[@hidden]"),
            buttonsClose = $$(".close");

    public BootstrapAlertsPage clickAutocloseableAlert(int i) {
        autocloseableAlerts.get(i).click();
        return this;
    }

    public BootstrapAlertsPage clickNormalAlert(int i) {
        normalAlerts.get(i).click();
        return this;
    }

    public BootstrapAlertsPage verifyAutocloseableMessageAppeared(int i, Condition c) {
        verifyAlertMessageAppeared(autocloseableMessages, i, c);
        return this;
    }

    public BootstrapAlertsPage verifyNormalMessageAppeared(int i, Condition c) {
        verifyAlertMessageAppeared(normalMessages, i, c);
        return this;
    }

    public BootstrapAlertsPage closeNormalMessage(int i) {
        buttonsClose.get(i).click();
        return this;
    }

    public void verifyNormalMessageDisappeared(int i) {
        normalMessages.get(i).should(disappear);
    }

    public void verifyAutocloseableMessageDisappeared(int i) {
        waitUntilAlertMessageDisappears(autocloseableMessages.get(i), 7);
    }

    private void verifyAlertMessageAppeared(ElementsCollection collection, int i, Condition c) {
        collection.get(i).shouldHave(attribute("style",
                "display: block;"), c);
    }
}