package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;

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

    public static String getContentOfTheFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOWNLOAD_DIR +
                File.separator + filename))) {
            ArrayList<String> content = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = reader.readLine()) != null) {
                content.add(strCurrentLine);
            }
            reader.close();
            return String.join("\n", content);
        }
    }
}
