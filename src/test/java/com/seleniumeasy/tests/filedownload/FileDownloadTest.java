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
    private final String FILE = "easyinfo.txt",
            INPUT_MESSAGE = "Hello\nWorld!";

    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Test
    public void downloadFileTest() throws IOException {
        fileDownloadPage
                .clickAlertAndModals()
                .openFileDownload()
                .enterYourMessage(INPUT_MESSAGE)
                .clickGenerateFile()
                .downloadGeneratedFile();
        assertThat(getContentOfTheFile(FILE)).isEqualTo(INPUT_MESSAGE);
    }

    @After
    public void deleteDownloadedFile() {
        try {
            Files.delete(Paths.get(DOWNLOAD_DIR + File.separator + FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
