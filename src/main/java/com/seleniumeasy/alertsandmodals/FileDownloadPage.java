package com.seleniumeasy.alertsandmodals;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.seleniumeasy.DemoHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;

public class FileDownloadPage extends DemoHomePage {
    private final SelenideElement fieldEnterData = $("#textbox"),
            buttonGenerateFile = $("#create"),
            buttonDownload = $("#link-to-download");

    public FileDownloadPage enterYourMessage(String yourMessage) {
        fieldEnterData.sendKeys(yourMessage);
        return this;
    }

    public FileDownloadPage clickGenerateFile() {
        buttonGenerateFile.click();
        return this;
    }

    public void downloadGeneratedFile() {
        buttonDownload.click();
    }

    public String getContentOfTheFile(String filename) throws IOException {
        File downloadedFile = new File(DOWNLOAD_DIR + File.separator + filename);
        waitForFile(downloadedFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(downloadedFile))) {
            ArrayList<String> content = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = reader.readLine()) != null) {
                content.add(strCurrentLine);
            }
            reader.close();
            return String.join("\n", content);
        }
    }

    private void waitForFile(File file) {
        Wait<WebDriver> wait = new FluentWait<>(WebDriverRunner.getWebDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        wait.until((condition) -> file.exists());
    }
}