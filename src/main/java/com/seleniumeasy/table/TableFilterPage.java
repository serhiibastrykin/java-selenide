package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class TableFilterPage extends DemoHomePage {
    private final ElementsCollection filters = $$(".btn-group button"),
            rows = $$("tbody tr");

    public TableFilterPage clickColumn(int colIndex) {
        sleep(200);
        filters.get(colIndex).click();
        return this;
    }

    public TableFilterPage clickColumn(String colName) {
        filters.find(exactText(colName)).click();
        return this;
    }

    public void verifyItemsColor(String color) {
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).isDisplayed())
                verifyColor(i, attribute("style", "color: " + color + ";"));
        }
    }

    public void verifyAllRowsDisplayed() throws Exception {
        int visibleRowsCount = 0;
        for (SelenideElement row : rows) {
            if (row.isDisplayed())
                visibleRowsCount++;
        }
        if (visibleRowsCount != rows.size())
            throw new Exception("Not all rows are displayed!\nExpected: " + rows.size() + "\nActual: " + visibleRowsCount);
    }

    private void verifyColor(int rowIndex, Condition c) {
        rows.get(rowIndex).$$("td .media-photo").get(0).shouldHave(c);
    }
}