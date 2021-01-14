package com.seleniumeasy.tests.dropdown;

import com.seleniumeasy.inputforms.SelectDropdownListPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.SELECT_DROPDOWN_LIST;

public class DropdownListTest extends SettingsSeleniumEasy {
    private final String daySelected = "Friday";

    SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage();

    @Test
    public void selectValueFromDropdown() {
        selectDropdownListPage
                .openInputForms(SELECT_DROPDOWN_LIST, SelectDropdownListPage.class)
                .clickPleaseSelect()
                .selectValue()
                .validateSelectedValue(daySelected);
    }
}