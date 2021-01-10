package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableSortAndSearchPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.Table.TABLE_SORT_AND_SEARCH;

public class TableSortAndSearchTest extends SettingsSeleniumEasy {
    private final String POSITION = "Chief",
            AGE = "22",
            CELL_TEXT_ASC = "Fri 9th Oct 09",
            CELL_TEXT_DESC = "Development Lead";

    TableSortAndSearchPage tableSortAndSearchPage = new TableSortAndSearchPage();

    @Test
    public void testSearchInTheTableByPosition() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText(POSITION)
                .verifyFoundValues("Position", text(POSITION));
    }

    @Test
    public void testSortingOfTheTableAsc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .verifyColumnValue(1, "Start date", exactText(CELL_TEXT_ASC));
    }

    @Test
    public void testSortingOfTheTableDesc() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .clickColumn(1)
                .verifyColumnValue(8, 1, exactText(CELL_TEXT_DESC));
    }

    @Test
    public void testSearchAndSortContentByAge() {
        tableSortAndSearchPage
                .openTable(TABLE_SORT_AND_SEARCH, TableSortAndSearchPage.class)
                .enterSearchText(AGE)
                .clickColumn("Age")
                .verifyColumnValue(1, "Age", exactText(AGE));
    }
}
