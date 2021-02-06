package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableSortAndSearchPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.Table.TABLE_SORT_AND_SEARCH;

public class TableSortAndSearchTest extends SettingsSeleniumEasy {

    TableSortAndSearchPage tableSortAndSearchPage = new TableSortAndSearchPage();

    @Test
    public void testSearchInTheTableByPosition() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText("Chief")
                .verifyFoundValues("Position", text("Chief"));
    }

    @Test
    public void testSortingOfTheTableAsc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .verifyColumnValue(1, "Start date", exactText("Fri 9th Oct 09"));
    }

    @Test
    public void testSortingOfTheTableDesc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .clickColumn(1)
                .verifyColumnValue(8, 1, exactText("Development Lead"));
    }

    @Test
    public void testSearchAndSortContentByAge() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText("22")
                .clickColumn("Age")
                .verifyColumnValue(1, "Age", exactText("22"));
    }

    @Test
    public void testTablePagination() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .clickPage(2)
                .verifyClickedPage(0, exactText("D. Rios"));
    }

    @Test
    public void testChangeEntriesSize() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .changeEntriesSize(25)
                .clickColumn("Start date")
                .clickPage(3)
                .verifyColumnValue(5, 2, exactText("London"));
    }
}