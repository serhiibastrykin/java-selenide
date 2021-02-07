package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.BootstrapModalsPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.AlertsAndModals.BOOTSTRAP_MODALS;

public class BootstrapModalsTest extends BaseTest {

    BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage();

    @Test
    public void testClosingMultipleModals() {
        bootstrapModalsPage
                .openAlertsAndModals(BOOTSTRAP_MODALS, BootstrapModalsPage.class)
                .clickLaunchFirstModal()
                .clickLaunchSecondModal()
                .closeSecondModal()
                .verifySecondModalClosed()
                .closeFirstModal()
                .verifyFirstModalClosed();
    }

    @Test
    public void testSavingChangesInFirstModal() {
        bootstrapModalsPage
                .openAlertsAndModals(BOOTSTRAP_MODALS, BootstrapModalsPage.class)
                .clickLaunchFirstModal()
                .clickSaveChangesFirstModal()
                .verifyBothModalsNotDisplayed();
    }

    @Test
    public void testSavingChangesInSecondModal() {
        bootstrapModalsPage
                .openAlertsAndModals(BOOTSTRAP_MODALS, BootstrapModalsPage.class)
                .clickLaunchFirstModal()
                .clickLaunchSecondModal()
                .clickSaveChangesSecondModal()
                .verifyBothModalsNotDisplayed();
    }
}