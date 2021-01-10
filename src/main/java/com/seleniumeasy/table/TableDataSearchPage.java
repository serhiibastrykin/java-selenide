package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class TableDataSearchPage extends DemoHomePage {
    private final SelenideElement BUTTON_FILTER = $(".btn-filter");
    private final ElementsCollection COLUMNS = $$(".filterable .table thead th input"),
            ROWS = $$(".filterable .table tbody tr");

    public TableDataSearchPage clickFilterButton() {
        sleep(500);
        BUTTON_FILTER.click();
        return this;
    }

    public TableDataSearchPage enterSearchText(int colIndex, String text) {
        COLUMNS.get(colIndex).sendKeys(text);
        return this;
    }

    public TableDataSearchPage enterSearchText(String colName, String text) {
        int colIndex = getColumnIndex(colName);
        COLUMNS.get(colIndex).sendKeys(text);
        return this;
    }

    public void verifyFoundValues(int colIndex, Condition c) {
        for (int i = 0; i < ROWS.size(); i++) {
            if (ROWS.get(i).isDisplayed())
                verifyColumnValue(i, colIndex, c);
        }
    }

    public void verifyFoundValues(String colName, Condition c) {
        for (int i = 0; i < ROWS.size(); i++) {
            if (ROWS.get(i).isDisplayed())
                verifyColumnValue(i, colName, c);
        }
    }

    private void verifyColumnValue(int rowIndex, int colIndex, Condition c) {
        getCellText(rowIndex, colIndex).shouldHave(c);
    }

    private void verifyColumnValue(int rowIndex, String colName, Condition c) {
        int colIndex = getColumnIndex(colName);
        getCellText(rowIndex, colIndex).shouldHave(c);
    }

    private int getColumnIndex(String colName) {
        int colIndex = -1;
        for (int i = 0; i < COLUMNS.size(); i++) {
            String columnText = COLUMNS.get(i).getAttribute("placeholder");
            if (columnText != null && columnText.equals(colName)) {
                colIndex = i;
                break;
            }
        }
        assertThat(colIndex).as("Cannot find index for column " + colName).isNotEqualTo(-1);
        return colIndex;
    }

    private SelenideElement getCellText(int rowIndex, int colIndex) {
        return ROWS.get(rowIndex).$$("td").get(colIndex);
    }
}