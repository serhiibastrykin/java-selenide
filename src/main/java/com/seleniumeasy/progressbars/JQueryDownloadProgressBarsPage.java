package com.seleniumeasy.progressbars;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class JQueryDownloadProgressBarsPage extends BasePage {
    private final SelenideElement buttonStartDownload = $("#downloadButton"),
            buttonCancelDownload = $x("//button[contains(text(), 'Cancel Download')]"),
            buttonClose = $x("//button[contains(text(), 'Close')]"),
            downloadForm = $("div[role=dialog]"),
            downloadStatus = $("div[class=progress-label]");

    public JQueryDownloadProgressBarsPage clickStartDownload() {
        buttonStartDownload.click();
        return this;
    }

    public JQueryDownloadProgressBarsPage clickCancelDownload() {
        buttonCancelDownload.click();
        return this;
    }

    public JQueryDownloadProgressBarsPage clickClose() {
        buttonClose.click();
        return this;
    }

    public JQueryDownloadProgressBarsPage verifyDownloadForm(Condition c) {
        downloadForm.should(c);
        return this;
    }

    public JQueryDownloadProgressBarsPage verifyFileIsDownloaded() {
        downloadStatus.waitUntil(exactText("Complete!"), 10000, 200);
        return this;
    }
}