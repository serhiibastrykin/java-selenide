package com.seleniumeasy.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.seleniumeasy.waits.CustomWaits.waitForFile;
import static java.util.Objects.requireNonNull;
import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;

public class TableDataDownloadPage extends DemoHomePage {
    public static final String FILE = "Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.csv";
    private final SelenideElement inputSearch = $("#example_filter input");
    private final ElementsCollection headers = $$("thead th"),
            rows = $$("tbody tr"),
            buttons = $$(".dt-buttons span"),
            pagination = $$("#example_paginate a");

    public TableDataDownloadPage clickColumn(int colIndex) {
        sleep(200);
        headers.get(colIndex).click();
        return this;
    }

    public TableDataDownloadPage clickColumn(String colName) {
        sleep(200);
        headers.find(exactText(colName)).click();
        return this;
    }

    public TableDataDownloadPage clickButton(String buttonName) {
        sleep(200);
        buttons.find(exactText(buttonName)).click();
        return this;
    }

    public TableDataDownloadPage clickPage(int pageIndex) {
        sleep(200);
        pagination.get(pageIndex).click();
        return this;
    }

    public TableDataDownloadPage enterSearchText(String text) {
        sleep(200);
        inputSearch.setValue(text);
        return this;
    }

    public void closePrintDialog() {
        try {
            Robot r = new Robot();
            r.delay(4000);
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void compareDisplayedAndDownloadedData() throws IOException {
        validateFileIsDownloaded();
        List<List<String>> entireContent = getEntireContent();
        List<String> joinedContent = joinContent(entireContent);
        Assert.assertEquals(joinedContent, readDownloadedFileContent());
    }

    private void validateFileIsDownloaded() throws IOException {
        File downloadedFile = new File(DOWNLOAD_DIR + File.separator + FILE);
        waitForFile(downloadedFile, 5);
        if (!downloadedFile.exists()) {
            throw new IOException("The file" + FILE + "doesn't exist!");
        }
    }

    private List<String> joinContent(List<List<String>> collections) {
        String delimiter = "\"";
        List<String> content = new ArrayList<>();
        for (List<String> collection : collections) {
            content.add(delimiter + String.join(delimiter + "," + delimiter, collection) + delimiter);
        }
        System.out.println("Number of rows displayed: " + content.size());
        System.out.println(content);
        return content;
    }

    private List<String> readDownloadedFileContent() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOWNLOAD_DIR +
                File.separator + FILE))) {
            List<String> fileContent = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = reader.readLine()) != null) {
                fileContent.add(strCurrentLine);
            }
            reader.close();
            System.out.println("Number of rows inside the file: " + fileContent.size());
            System.out.println(fileContent);
            return fileContent;
        }
    }

    private List<List<String>> getEntireContent() {
        List<List<String>> entireContent = new ArrayList<>();
        entireContent.add(getColumnNames());
        int i = 1;
        do {
            entireContent.addAll(getPageContent());
            pagination.last().click();
            i++;
        } while (requireNonNull(pagination.get(i).getAttribute("class")).contains("current"));
        return entireContent;
    }

    private List<List<String>> getPageContent() {
        List<List<String>> pageContent = new ArrayList<>();
        for (SelenideElement element : rows) {
            List<SelenideElement> cells = element.$$(By.tagName("td"));
            List<String> columns = new ArrayList<>();
            for (SelenideElement cell : cells) {
                columns.add(cell.getText());
            }
            pageContent.add(columns);
        }
        return pageContent;
    }

    private List<String> getColumnNames() {
        List<String> colNames = new ArrayList<>();
        for (SelenideElement header : headers) {
            colNames.add(header.getText());
        }
        return colNames;
    }
}