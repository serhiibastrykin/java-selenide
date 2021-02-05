package com.seleniumeasy.tests.progressbars;

import com.seleniumeasy.progressbars.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.ProgressBars.BOOTSTRAP_PROGRESS_BAR;

public class BootstrapProgressBarTest extends SettingsSeleniumEasy {

    BootstrapProgressBarPage bootstrapProgressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testDownloadFile() {
        bootstrapProgressBarPage
                .openProgressBars(BOOTSTRAP_PROGRESS_BAR, BootstrapProgressBarPage.class)
                .clickDownload()
                .verifyFileIsDownloaded();
    }
}