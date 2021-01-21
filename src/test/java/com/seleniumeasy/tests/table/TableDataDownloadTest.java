package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableDataDownloadPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.seleniumeasy.enums.Table.TABLE_DATA_DOWNLOAD;
import static com.seleniumeasy.table.TableDataDownloadPage.FILE;

public class TableDataDownloadTest extends SettingsSeleniumEasy {

    TableDataDownloadPage tableDataDownloadPage = new TableDataDownloadPage();

    @Test
    public void testDataComparison() throws IOException {
        tableDataDownloadPage
                .openTable(TABLE_DATA_DOWNLOAD, TableDataDownloadPage.class)
                .clickColumn("Office")
                .clickButton("CSV")
                .compareDisplayedAndDownloadedData();
    }

    @Test
    public void testSortedDataComparison() throws IOException {
        tableDataDownloadPage
                .openTable(TABLE_DATA_DOWNLOAD, TableDataDownloadPage.class)
                .clickPage(3)
                .enterSearchText("Develop")
                .clickColumn(4)
                .clickButton(1)
                .compareDisplayedAndDownloadedData();
    }

    @Test
    public void testFileDownloading() throws IOException {
        tableDataDownloadPage
                .openTable(TABLE_DATA_DOWNLOAD, TableDataDownloadPage.class)
                .clickButton(1)
                .validateFileIsDownloaded();
    }

    @Test
    public void testClosePrintDialog() {
        tableDataDownloadPage
                .openTable(TABLE_DATA_DOWNLOAD, TableDataDownloadPage.class)
                .clickButton("Print")
                .closePrintDialog();
    }

    @AfterMethod
    public void deleteDownloadedFile() {
        try {
            Files.delete(Paths.get(DOWNLOAD_DIR + File.separator + FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}