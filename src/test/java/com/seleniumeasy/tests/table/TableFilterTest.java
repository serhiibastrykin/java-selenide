package com.seleniumeasy.tests.table;

import com.seleniumeasy.table.TableFilterPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.Table.TABLE_FILTER;

public class TableFilterTest extends BaseTest {

    TableFilterPage tableFilterPage = new TableFilterPage();

    @Test
    public void testFilterByColors() {
        tableFilterPage
                .openTable(TABLE_FILTER, TableFilterPage.class)
                .clickFilter(1)
                .verifyItemsColor("orange");
    }

    @Test
    public void testFilterAll() throws Exception {
        tableFilterPage
                .openTable(TABLE_FILTER, TableFilterPage.class)
                .clickFilter("All")
                .verifyAllRowsDisplayed();
    }
}