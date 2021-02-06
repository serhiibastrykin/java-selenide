package io.tusdemo.test;

import io.tusdemo.UploadFilePage;
import org.testng.annotations.Test;
import utils.SettingsTusDemo;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class UploadFileTest extends SettingsTusDemo {
    private final String path = "C:/easyinfo.txt";
    private final File uploadedFile = new File(path);

    UploadFilePage uploadFileClass = new UploadFilePage();

    @Test
    public void uploadFileTest() throws IOException {
        uploadFileClass
                .uploadFile(uploadedFile)
                .verifyUploadingIsSuccessful("The upload is complete!")
                .clickDownloadButton()
                .validateDisplayedText(readAllLines(get(path)).get(0));
    }
}