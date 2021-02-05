package com.seleniumeasy.tests.progressbars;

import com.seleniumeasy.progressbars.JQueryDownloadProgressBarsPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.*;
import static com.seleniumeasy.enums.ProgressBars.JQUERY_DOWNLOAD_PROGRESS_BARS;

public class JQueryDownloadProgressBarsTest extends SettingsSeleniumEasy {

    JQueryDownloadProgressBarsPage jQueryDownloadProgressBarsPage = new JQueryDownloadProgressBarsPage();

    @Test
    public void testCompleteDownload() {
        jQueryDownloadProgressBarsPage
                .openProgressBars(JQUERY_DOWNLOAD_PROGRESS_BARS, JQueryDownloadProgressBarsPage.class)
                .clickStartDownload()
                .verifyDownloadForm(visible)
                .verifyFileIsDownloaded()
                .clickClose()
                .verifyDownloadForm(hidden);
    }

    @Test
    public void testCancelDownload() {
        jQueryDownloadProgressBarsPage
                .openProgressBars(JQUERY_DOWNLOAD_PROGRESS_BARS, JQueryDownloadProgressBarsPage.class)
                .clickStartDownload()
                .verifyDownloadForm(visible)
                .clickCancelDownload()
                .verifyDownloadForm(hidden);
    }
}