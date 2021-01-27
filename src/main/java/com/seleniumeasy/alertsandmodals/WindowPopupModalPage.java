package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WindowPopupModalPage extends DemoHomePage {
    private final SelenideElement buttonFollowAll = $("#followall"),
            popupFacebook = $("#facebook"),
            popupTwitter = $("a[aria-label=Twitter]"),
            popupGoogle = $("div[title=Google]");

    public WindowPopupModalPage clickFollowAll() {
        buttonFollowAll.click();
        return this;
    }

    public WindowPopupModalPage verifyGooglePopupIsOpen() {
        verifyPopupIsOpen(1, popupGoogle);
        return this;
    }

    public WindowPopupModalPage verifyTwitterPopupIsOpen() {
        verifyPopupIsOpen(2, popupTwitter);
        return this;
    }

    public WindowPopupModalPage verifyFacebookPopupIsOpen() {
        verifyPopupIsOpen(3, popupFacebook);
        return this;
    }

    public WindowPopupModalPage closeGooglePopup() {
        closePopup(1);
        return this;
    }

    public WindowPopupModalPage closeTwitterPopup() {
        closePopup(2);
        return this;
    }

    public WindowPopupModalPage closeFacebookPopup() {
        closePopup(3);
        return this;
    }

    public WindowPopupModalPage verifyGooglePopupIsClosed() {
        verifyPopupIsClosed(popupGoogle);
        return this;
    }

    public WindowPopupModalPage verifyTwitterPopupIsClosed() {
        verifyPopupIsClosed(popupTwitter);
        return this;
    }

    public WindowPopupModalPage verifyFacebookPopupIsClosed() {
        verifyPopupIsClosed(popupFacebook);
        return this;
    }

    private void verifyPopupIsOpen(int i, SelenideElement element) {
        ArrayList<String> popups = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(popups.get(i));
        element.shouldBe(visible);
    }

    private void closePopup(int i) {
        ArrayList<String> popups = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(popups.get(i)).close();
    }

    private void verifyPopupIsClosed(SelenideElement element) {
        element.shouldNotBe(visible);
    }

    public void getInfoAboutWindows() {
        List<String> ids = new ArrayList<>(getWebDriver().getWindowHandles());
        List<Pair<String, String>> windows = new ArrayList<>();
        for (String id : ids) {
            String name = getWebDriver().switchTo().window(id).getTitle();
            Pair<String, String> values = new Pair<>(id, name);
            windows.add(values);
        }
        System.out.println(windows);
    }
}