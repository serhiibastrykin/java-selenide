package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.JavascriptAlertsPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.AlertsAndModals.JAVASCRIPT_ALERTS;

public class JavascriptAlertsTest extends SettingsSeleniumEasy {
    private final String confirmMessage = "You pressed OK!",
            dismissMessage = "You pressed Cancel!";

    JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage();

    @Test
    public void testConfirmAlertBox() {
        javascriptAlertsPage
                .openAlertsAndModals(JAVASCRIPT_ALERTS, JavascriptAlertsPage.class)
                .clickClickMe()
                .confirmAlert()
                .validateDisplayedMessage(confirmMessage);
    }

    @Test
    public void testDismissAlertBox() {
        javascriptAlertsPage
                .openAlertsAndModals(JAVASCRIPT_ALERTS, JavascriptAlertsPage.class)
                .clickClickMe()
                .dismissAlert()
                .validateDisplayedMessage(dismissMessage);
    }
}