package io.tusdemo;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UploadFilePage {
    private final SelenideElement BUTTON_CHOOSE_FILE = $("#js-file-input"),
            DISPLAYED_MESSAGE = $("div .heading"),
            BUTTON_DOWNLOAD = $(".button-primary"),
            DISPLAYED_TEXT = $("html body pre");

    public UploadFilePage uploadFile(File uploadedFile) {
        BUTTON_CHOOSE_FILE.uploadFile(uploadedFile);
        return this;
    }

    public UploadFilePage verifyUploadingIsSuccessful(String message) {
        DISPLAYED_MESSAGE.shouldHave(text(message));
        return this;
    }

    public UploadFilePage clickDownloadButton() {
        BUTTON_DOWNLOAD.click();
        return this;
    }

    public void validateDisplayedText(String content) {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        DISPLAYED_TEXT.shouldHave(text(content));
    }
}