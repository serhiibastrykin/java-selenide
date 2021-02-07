package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableDataSearchPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.Table.TABLE_DATA_SEARCH;

public class TableDataSearchTest extends BaseTest {
    private final String firstName = "Byron",
            rowNumber = "2";

    TableDataSearchPage tableDataSearchPage = new TableDataSearchPage();

    @Test
    public void searchDataByFirstName() {
        tableDataSearchPage
                .openTable(TABLE_DATA_SEARCH, TableDataSearchPage.class)
                .clickFilterButton()
                .enterSearchText("First Name", firstName)
                .verifyFoundValues("First Name", exactText(firstName));
    }

    @Test
    public void searchDataByRowNumber() {
        tableDataSearchPage
                .openTable(TABLE_DATA_SEARCH, TableDataSearchPage.class)
                .clickFilterButton()
                .enterSearchText(0, rowNumber)
                .verifyFoundValues(0, exactText(rowNumber));
    }
}