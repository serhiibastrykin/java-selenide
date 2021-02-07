package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.BootstrapAlertsPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.AlertsAndModals.BOOTSTRAP_ALERTS;

public class BootstrapAlertsTest extends BaseTest {

    BootstrapAlertsPage bootstrapAlertsPage = new BootstrapAlertsPage();

    @Test
    public void testAutocloseableSuccessMessage() {
        bootstrapAlertsPage
                .openAlertsAndModals(BOOTSTRAP_ALERTS, BootstrapAlertsPage.class)
                .clickAutocloseableAlert(0)
                .verifyAutocloseableMessageAppeared(0, text("autocloseable success message"))
                .verifyAutocloseableMessageDisappeared(0);
    }

    @Test
    public void testAutocloseableWarningMessage() {
        bootstrapAlertsPage
                .openAlertsAndModals(BOOTSTRAP_ALERTS, BootstrapAlertsPage.class)
                .clickAutocloseableAlert(1)
                .verifyAutocloseableMessageAppeared(1, text("autocloseable warning message"))
                .verifyAutocloseableMessageDisappeared(1);
    }

    @Test
    public void testAutocloseableDangerMessage() {
        bootstrapAlertsPage
                .openAlertsAndModals(BOOTSTRAP_ALERTS, BootstrapAlertsPage.class)
                .clickAutocloseableAlert(2)
                .verifyAutocloseableMessageAppeared(2, text("autocloseable danger message"))
                .verifyAutocloseableMessageDisappeared(2);
    }

    @Test
    public void testAutocloseableInfoMessage() {
        bootstrapAlertsPage
                .openAlertsAndModals(BOOTSTRAP_ALERTS, BootstrapAlertsPage.class)
                .clickAutocloseableAlert(3)
                .verifyAutocloseableMessageAppeared(3, text("autocloseable info message"))
                .verifyAutocloseableMessageDisappeared(3);
    }

    @Test
    public void testClosingNormalSuccessMessage() {
        bootstrapAlertsPage
                .openAlertsAndModals(BOOTSTRAP_ALERTS, BootstrapAlertsPage.class)
                .clickNormalAlert(0)
                .verifyNormalMessageAppeared(0, text("normal success message"))
                .closeNormalMessage(0)
                .verifyNormalMessageDisappeared(0);
    }
}