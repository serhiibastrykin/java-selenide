package com.seleniumeasy.progressbars;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class BootstrapProgressBarPage extends BasePage {
    private final SelenideElement buttonDownload = $("#cricle-btn"),
            downloadStatus = $("div[class=percenttext]");

    public BootstrapProgressBarPage clickDownload() {
        buttonDownload.click();
        return this;
    }

    public void verifyFileIsDownloaded() {
        downloadStatus.waitUntil(exactText("100%"), 30000, 200);
    }
}