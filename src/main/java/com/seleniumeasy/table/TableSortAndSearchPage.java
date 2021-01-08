package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class TableSortAndSearchPage extends DemoHomePage {
    private final SelenideElement TABLE_HEADER = $(".thead-inverse"),
            TABLE_BODY = $("tbody"),
            INPUT_SEARCH = $("input[type='search']");

    public TableSortAndSearchPage clickColumn(int colIndex) {
        sleep(200);
        TABLE_HEADER.$$("th").get(colIndex).click();
        return this;
    }

    public TableSortAndSearchPage clickColumn(String colText) {
        sleep(200);
        TABLE_HEADER.$$("th").find(exactText(colText)).click();
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
        sleep(500);
        INPUT_SEARCH.sendKeys(text);
        return this;
    }

    public void verifyFoundValues(String colName, Condition c) {
        int rowCount = TABLE_BODY.$$("tr").size();
        for (int i = 0; i < rowCount; i++) {
            verifyColumnValue(i, colName, c);
        }
    }

    private int getColumnIndex(String colName) {
        ElementsCollection columns = TABLE_HEADER.$$("th");
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
        return TABLE_BODY.$$("tr").get(rowIndex);
    }

    private SelenideElement getCellText(int rowIndex, int colIndex) {
        return getTableRow(rowIndex).$$("td").get(colIndex);
    }
}
