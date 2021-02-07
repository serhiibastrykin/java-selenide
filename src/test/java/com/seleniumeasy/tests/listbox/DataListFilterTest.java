package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.DataListFilterPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.ListBox.DATA_LIST_FILTER;

public class DataListFilterTest extends BaseTest {

    DataListFilterPage dataListFilterPage = new DataListFilterPage();

    @Test
    public void testFilteringDataInList() {
        dataListFilterPage
                .openListBox(DATA_LIST_FILTER, DataListFilterPage.class)
                .enterSearchText("shizzle")
                .validateFoundUsers("shizzle");
    }
}