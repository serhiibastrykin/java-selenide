package com.seleniumeasy.tests.dropdown;

import com.seleniumeasy.inputforms.SelectDropdownListPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

public class DropdownListTest extends SettingsSeleniumEasy {
    private final String DAY_SELECTED = "Friday";

    SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage();

    @Test
    public void selectValueFromDropdown() {
        selectDropdownListPage
                .clickInputFormsDropdown1()
                .openSelectDropdownList()
                .clickPleaseSelect()
                .selectValue()
                .validateSelectedValue(DAY_SELECTED);
    }
}
