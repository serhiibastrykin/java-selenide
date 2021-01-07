package com.seleniumeasy.tests.filedownload;

import com.seleniumeasy.alertsandmodals.FileDownloadPage;
import org.junit.After;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
        assertThat(getContentOfTheFile()).isEqualTo(INPUT_MESSAGE);
    }

    private String getContentOfTheFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DOWNLOAD_DIR +
                File.separator + FILE));
        try {
            ArrayList<String> content = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = reader.readLine()) != null) {
                content.add(strCurrentLine);
            }
            return String.join("\n", content);
        } finally {
            reader.close();
        }
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
