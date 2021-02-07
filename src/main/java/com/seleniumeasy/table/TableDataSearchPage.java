package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TableDataSearchPage extends BasePage {
    private final SelenideElement buttonFilter = $(".btn-filter");
    private final ElementsCollection columns = $$(".filterable .table thead th input"),
            rows = $$(".filterable .table tbody tr");

    public TableDataSearchPage clickFilterButton() {
        buttonFilter.click();
        return this;
    }

    public TableDataSearchPage enterSearchText(int colIndex, String text) {
        columns.get(colIndex).setValue(text);
        return this;
    }

    public TableDataSearchPage enterSearchText(String colName, String text) {
        int colIndex = getColumnIndex(colName);
        columns.get(colIndex).setValue(text);
        return this;
    }

    public void verifyFoundValues(int colIndex, Condition c) {
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).isDisplayed())
                verifyColumnValue(i, colIndex, c);
        }
    }

    public void verifyFoundValues(String colName, Condition c) {
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).isDisplayed())
                verifyColumnValue(i, colName, c);
        }
    }

    private void verifyColumnValue(int rowIndex, int colIndex, Condition c) {
        getCellText(rowIndex, colIndex).should(c);
    }

    private void verifyColumnValue(int rowIndex, String colName, Condition c) {
        int colIndex = getColumnIndex(colName);
        getCellText(rowIndex, colIndex).should(c);
    }

    private int getColumnIndex(String colName) {
        int colIndex = -1;
        for (int i = 0; i < columns.size(); i++) {
            String columnText = columns.get(i).getAttribute("placeholder");
            if (columnText != null && columnText.equals(colName)) {
                colIndex = i;
                break;
            }
        }
        assertThat(colIndex).as("Cannot find index for column " + colName).isNotEqualTo(-1);
        return colIndex;
    }

    private SelenideElement getCellText(int rowIndex, int colIndex) {
        return rows.get(rowIndex).$$("td").get(colIndex);
    }
}