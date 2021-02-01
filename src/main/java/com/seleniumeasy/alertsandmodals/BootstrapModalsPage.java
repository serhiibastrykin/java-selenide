package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BootstrapModalsPage extends DemoHomePage {
    private final SelenideElement buttonLaunchFirstModal = $x("//a[@href='#myModal']"),
            buttonLaunchSecondModal = $x("//div[@class='modal-content']//a[contains(text(), 'Launch modal')]"),
            buttonCloseFirstModal = $x("//div[@id='myModal']//a[contains(text(), 'Close')]"),
            buttonCloseSecondModal = $x("//div[@id='myModal2']//a[contains(text(), 'Close')]"),
            buttonSaveChangesFirstModal = $x("//div[@id='myModal']//a[contains(text(), 'Save changes')]"),
            buttonSaveChangesSecondModal = $x("//div[@id='myModal2']//a[contains(text(), 'Save changes')]"),
            firstModal = $("div[id='myModal'] .modal-content"),
            secondModal = $("div[id='myModal2'] .modal-content"),
            openedModal = $(".modal-open");

    public BootstrapModalsPage clickLaunchFirstModal() {
        buttonLaunchFirstModal.click();
        return this;
    }

    public BootstrapModalsPage clickLaunchSecondModal() {
        buttonLaunchSecondModal.click();
        return this;
    }

    public BootstrapModalsPage closeFirstModal() {
        buttonCloseFirstModal.click();
        return this;
    }

    public BootstrapModalsPage closeSecondModal() {
        buttonCloseSecondModal.click();
        return this;
    }

    public BootstrapModalsPage clickSaveChangesFirstModal() {
        buttonSaveChangesFirstModal.click();
        return this;
    }

    public BootstrapModalsPage clickSaveChangesSecondModal() {
        buttonSaveChangesSecondModal.click();
        return this;
    }

    public BootstrapModalsPage verifyFirstModalClosed() {
        firstModal.shouldNotBe(visible);
        return this;
    }

    public BootstrapModalsPage verifySecondModalClosed() {
        secondModal.shouldNotBe(visible);
        return this;
    }

    public void verifyBothModalsNotDisplayed() {
        openedModal.shouldNotBe(visible);
    }
}