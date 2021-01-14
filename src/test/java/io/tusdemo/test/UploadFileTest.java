package io.tusdemo.test;

import io.tusdemo.UploadFilePage;
import org.junit.Test;
import utils.SettingsTusDemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadFileTest extends SettingsTusDemo {
    private final String path = "C:/easyinfo.txt",
            successMessage = "The upload is complete!";
    private final File uploadedFile = new File(path);

    UploadFilePage uploadFileClass = new UploadFilePage();

    @Test
    public void uploadFileTest() throws IOException {
        uploadFileClass
                .uploadFile(uploadedFile)
                .verifyUploadingIsSuccessful(successMessage)
                .clickDownloadButton()
                .validateDisplayedText(Files.readAllLines(Paths.get(path)).get(0));
    }
}