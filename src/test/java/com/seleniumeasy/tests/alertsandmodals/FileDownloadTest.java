package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.FileDownloadPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.seleniumeasy.enums.AlertsAndModals.FILE_DOWNLOAD;
import static org.assertj.core.api.Assertions.assertThat;

public class FileDownloadTest extends SettingsSeleniumEasy {
    private final String file = "easyinfo.txt",
            inputMessage = "Hello\nWorld!";

    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Test
    public void downloadFileTest() throws IOException {
        fileDownloadPage
                .openAlertsAndModals(FILE_DOWNLOAD, FileDownloadPage.class)
                .enterYourMessage(inputMessage)
                .clickGenerateFile()
                .downloadGeneratedFile();
        assertThat(fileDownloadPage.getContentOfTheFile(file)).isEqualTo(inputMessage);
    }

    @AfterMethod
    public void deleteDownloadedFile() {
        try {
            Files.delete(Paths.get(DOWNLOAD_DIR + File.separator + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}