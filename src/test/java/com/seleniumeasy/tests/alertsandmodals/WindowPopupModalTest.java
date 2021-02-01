package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.WindowPopupModalPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.AlertsAndModals.WINDOW_POPUP_MODAL;

public class WindowPopupModalTest extends SettingsSeleniumEasy {

    WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage();

    @Test
    public void testOpeningThreePopups() {
        windowPopupModalPage
                .openAlertsAndModals(WINDOW_POPUP_MODAL, WindowPopupModalPage.class)
                .clickFollowAll()
                .verifyGooglePopupIsOpen()
                .verifyTwitterPopupIsOpen()
                .verifyFacebookPopupIsOpen();
    }

    @Test
    public void testClosingThreePopups() {
        windowPopupModalPage
                .openAlertsAndModals(WINDOW_POPUP_MODAL, WindowPopupModalPage.class)
                .clickFollowAll()
                .verifyGooglePopupIsOpen()
                .verifyTwitterPopupIsOpen()
                .verifyFacebookPopupIsOpen()
                .closeFacebookPopup()
                .closeTwitterPopup()
                .closeGooglePopup()
                .verifyGooglePopupIsClosed()
                .verifyTwitterPopupIsClosed()
                .verifyFacebookPopupIsClosed();
    }
}