package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableDataSearchPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.Table.TABLE_DATA_SEARCH;

public class TableDataSearchTest extends SettingsSeleniumEasy {
    private final String FIRST_NAME = "Byron",
            ROW_NUMBER = "2";

    TableDataSearchPage tableDataSearchPage = new TableDataSearchPage();

    @Test
    public void searchDataByFirstName() {
        tableDataSearchPage
                .openTable(TABLE_DATA_SEARCH, TableDataSearchPage.class)
                .clickFilterButton()
                .enterSearchText("First Name", FIRST_NAME)
                .verifyFoundValues("First Name", exactText(FIRST_NAME));
    }

    @Test
    public void searchDataByRowNumber() {
        tableDataSearchPage
                .openTable(TABLE_DATA_SEARCH, TableDataSearchPage.class)
                .clickFilterButton()
                .enterSearchText(0, ROW_NUMBER)
                .verifyFoundValues(0, exactText(ROW_NUMBER));
    }
}
