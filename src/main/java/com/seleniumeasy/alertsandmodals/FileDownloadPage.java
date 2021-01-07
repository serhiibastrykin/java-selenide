package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class FileDownloadPage extends DemoHomePage {
    private final SelenideElement FIELD_ENTER_DATA = $("#textbox"),
            BUTTON_GENERATE_FILE = $("#create"),
            BUTTON_DOWNLOAD = $("#link-to-download");

    public FileDownloadPage enterYourMessage(String yourMessage) {
        FIELD_ENTER_DATA.sendKeys(yourMessage);
        return this;
    }

    public FileDownloadPage clickGenerateFile() {
        BUTTON_GENERATE_FILE.click();
        return this;
    }

    public void downloadGeneratedFile() {
        BUTTON_DOWNLOAD.click();
        sleep(1000);
    }
}
