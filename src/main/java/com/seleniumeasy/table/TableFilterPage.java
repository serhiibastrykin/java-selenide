package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class TableFilterPage extends DemoHomePage {
    private final ElementsCollection FILTERS = $$(".btn-group button"),
            ROWS = $$("tbody tr");

    public TableFilterPage clickColumn(int colIndex) {
        FILTERS.get(colIndex).click();
        return this;
    }

    public TableFilterPage clickColumn(String colName) {
        FILTERS.find(exactText(colName)).click();
        return this;
    }

    public void verifyItemsColor(String color) {
        for (int i = 0; i < ROWS.size(); i++) {
            if (ROWS.get(i).isDisplayed())
                verifyColor(i, attribute("style", "color: " + color + ";"));
        }
    }

    public void verifyAllRowsDisplayed() throws Exception {
        int visibleRowsCount = 0;
        for (SelenideElement row : ROWS) {
            if (row.isDisplayed())
                visibleRowsCount++;
        }
        if (visibleRowsCount != ROWS.size())
            throw new Exception("Not all rows are displayed!\nExpected: " + ROWS.size() + "\nActual: " + visibleRowsCount);
    }

    private void verifyColor(int rowIndex, Condition c) {
        ROWS.get(rowIndex).$$("td .media-photo").get(0).shouldHave(c);
    }
}
