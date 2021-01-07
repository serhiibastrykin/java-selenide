package io.tusdemo.test;

import io.tusdemo.UploadFilePage;
import org.junit.Test;
import utils.SettingsTusDemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadFileTest extends SettingsTusDemo {
    private final String PATH = "C:/easyinfo.txt",
            SUCCESS_MESSAGE = "The upload is complete!";
    private final File UPLOADED_FILE = new File(PATH);

    UploadFilePage uploadFileClass = new UploadFilePage();

    @Test
    public void uploadFileTest() throws IOException {
        uploadFileClass
                .uploadFile(UPLOADED_FILE)
                .verifyUploadingIsSuccessful(SUCCESS_MESSAGE)
                .clickDownloadButton()
                .validateDisplayedText(Files.readAllLines(Paths.get(PATH)).get(0));
    }
}