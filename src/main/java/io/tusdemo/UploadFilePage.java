package io.tusdemo;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UploadFilePage {
    private final SelenideElement buttonChooseFile = $("#js-file-input"),
            displayedMessage = $("div .heading"),
            buttonDownload = $(".button-primary"),
            displayedText = $("html body pre");

    public UploadFilePage uploadFile(File uploadedFile) {
        buttonChooseFile.uploadFile(uploadedFile);
        return this;
    }

    public UploadFilePage verifyUploadingIsSuccessful(String message) {
        displayedMessage.shouldHave(text(message));
        return this;
    }

    public UploadFilePage clickDownloadButton() {
        buttonDownload.click();
        return this;
    }

    public void validateDisplayedText(String content) {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        displayedText.shouldHave(exactText(content));
    }
}