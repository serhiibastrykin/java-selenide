package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableSortAndSearchPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.Table.TABLE_SORT_AND_SEARCH;

public class TableSortAndSearchTest extends SettingsSeleniumEasy {
    private final String position = "Chief",
            cellTextAsc = "Fri 9th Oct 09",
            cellTextDesc = "Development Lead",
            age = "22",
            cellText = "D. Rios";

    TableSortAndSearchPage tableSortAndSearchPage = new TableSortAndSearchPage();

    @Test
    public void testSearchInTheTableByPosition() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText(position)
                .verifyFoundValues("Position", text(position));
    }

    @Test
    public void testSortingOfTheTableAsc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .verifyColumnValue(1, "Start date", exactText(cellTextAsc));
    }

    @Test
    public void testSortingOfTheTableDesc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .clickColumn(1)
                .verifyColumnValue(8, 1, exactText(cellTextDesc));
    }

    @Test
    public void testSearchAndSortContentByAge() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText(age)
                .clickColumn("Age")
                .verifyColumnValue(1, "Age", exactText(age));
    }

    @Test
    public void testTablePagination() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .clickPage(2)
                .verifyClickedPageIsOpen(0, exactText(cellText));
    }
}