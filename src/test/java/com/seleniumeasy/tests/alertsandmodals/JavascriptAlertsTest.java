package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.JavascriptAlertsPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.AlertsAndModals.JAVASCRIPT_ALERTS;

public class JavascriptAlertsTest extends SettingsSeleniumEasy {
    private final String confirmMessage = "You pressed OK!",
            dismissMessage = "You pressed Cancel!",
            name = "Serhii";

    JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage();

    @Test
    public void testConfirmAlertBox() {
        javascriptAlertsPage
                .openAlertsAndModals(JAVASCRIPT_ALERTS, JavascriptAlertsPage.class)
                .clickClickMe()
                .confirmAlert()
                .validateDisplayedMessage(exactText(confirmMessage));
    }

    @Test
    public void testDismissAlertBox() {
        javascriptAlertsPage
                .openAlertsAndModals(JAVASCRIPT_ALERTS, JavascriptAlertsPage.class)
                .clickClickMe()
                .dismissAlert()
                .validateDisplayedMessage(exactText(dismissMessage));
    }

    @Test
    public void testEnterNameInAlertBox() {
        javascriptAlertsPage
                .openAlertsAndModals(JAVASCRIPT_ALERTS, JavascriptAlertsPage.class)
                .clickClickForPromptBox()
                .enterName(name)
                .confirmAlert()
                .validateDisplayedName(text(name));
    }
}