package com.seleniumeasy.tests.progressbars;

import com.seleniumeasy.progressbars.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.ProgressBars.BOOTSTRAP_PROGRESS_BAR;

public class BootstrapProgressBarTest extends BaseTest {

    BootstrapProgressBarPage bootstrapProgressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testDownloadFile() {
        bootstrapProgressBarPage
                .openProgressBars(BOOTSTRAP_PROGRESS_BAR, BootstrapProgressBarPage.class)
                .clickDownload()
                .verifyFileIsDownloaded();
    }
}