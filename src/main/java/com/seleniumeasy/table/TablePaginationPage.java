package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;

public class TablePaginationPage extends DemoHomePage {
    private final ElementsCollection PAGINATION = $$(".pager li"),
            ROWS = $$("tbody tr");

    public TablePaginationPage clickPage(int pageIndex) {
        PAGINATION.get(pageIndex).$(tagName("a")).click();
        return this;
    }

    public void verifyClickedPageIsOpen(int rowIndex, int colIndex, Condition c) {
        ROWS.get(rowIndex).$$("td").get(colIndex).should(c);
    }
}