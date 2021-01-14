package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class TableSortAndSearchPage extends DemoHomePage {
    private final SelenideElement tableHeader = $(".thead-inverse"),
            tableBody = $("tbody"),
            inputSearch = $("input[type=search]");
    private final ElementsCollection pagination = $$("#example_paginate .paginate_button");

    public TableSortAndSearchPage clickColumn(int colIndex) {
        tableHeader.$$("th").get(colIndex).shouldBe(visible).click();
        return this;
    }

    public TableSortAndSearchPage clickColumn(String colName) {
        tableHeader.$$("th").find(exactText(colName)).shouldBe(visible).click();
        return this;
    }

    public void verifyColumnValue(int rowIndex, String colName, Condition c) {
        int colIndex = getColumnIndex(colName);
        getCellText(rowIndex, colIndex).shouldHave(c);
    }

    public void verifyColumnValue(int rowIndex, int colIndex, Condition c) {
        getCellText(rowIndex, colIndex).shouldHave(c);
    }

    public TableSortAndSearchPage enterSearchText(String text) {
        inputSearch.shouldBe(visible, empty).sendKeys(text);
        return this;
    }

    public void verifyFoundValues(String colName, Condition c) {
        int rowCount = tableBody.$$("tr").size();
        for (int i = 0; i < rowCount; i++) {
            verifyColumnValue(i, colName, c);
        }
    }

    public TableSortAndSearchPage clickPage(int pageIndex) {
        pagination.get(pageIndex).shouldBe(visible).click();
        return this;
    }

    public void verifyClickedPageIsOpen(int colIndex, Condition c) {
        getTableRow(0).$$("td").get(colIndex).should(c);
    }

    private int getColumnIndex(String colName) {
        ElementsCollection columns = tableHeader.$$("th");
        int colIndex = -1;
        for (int i = 0; i < columns.size(); i++) {
            String columnText = columns.get(i).text();
            if (columnText.equals(colName)) {
                colIndex = i;
                break;
            }
        }
        assertThat(colIndex).as("Cannot find index for column " + colName).isNotEqualTo(-1);
        return colIndex;
    }

    private SelenideElement getTableRow(int rowIndex) {
        return tableBody.$$("tr").get(rowIndex);
    }

    private SelenideElement getCellText(int rowIndex, int colIndex) {
        return getTableRow(rowIndex).$$("td").get(colIndex);
    }
}