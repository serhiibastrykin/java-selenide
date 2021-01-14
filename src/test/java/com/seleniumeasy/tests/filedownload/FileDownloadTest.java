package com.seleniumeasy.tests.filedownload;

import com.seleniumeasy.alertsandmodals.FileDownloadPage;
import org.junit.After;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.seleniumeasy.alertsandmodals.FileDownloadPage.getContentOfTheFile;
import static org.assertj.core.api.Assertions.assertThat;

public class FileDownloadTest extends SettingsSeleniumEasy {
    private final String file = "easyinfo.txt",
            inputMessage = "Hello\nWorld!";

    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Test
    public void downloadFileTest() throws IOException {
        fileDownloadPage
                .clickAlertAndModals()
                .openFileDownload()
                .enterYourMessage(inputMessage)
                .clickGenerateFile()
                .downloadGeneratedFile();
        assertThat(getContentOfTheFile(file)).isEqualTo(inputMessage);
    }

    @After
    public void deleteDownloadedFile() {
        try {
            Files.delete(Paths.get(DOWNLOAD_DIR + File.separator + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}