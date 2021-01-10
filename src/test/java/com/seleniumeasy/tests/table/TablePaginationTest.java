package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TablePaginationPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.Table.TABLE_PAGINATION;

public class TablePaginationTest extends SettingsSeleniumEasy {

    TablePaginationPage tablePaginationPage = new TablePaginationPage();

    @Test
    public void testPagination() {
        tablePaginationPage
                .openTable(TABLE_PAGINATION, TablePaginationPage.class)
                .clickPage(3)
                .verifyClickedPageIsOpen(10, 0, exactText("11"));
    }
}
