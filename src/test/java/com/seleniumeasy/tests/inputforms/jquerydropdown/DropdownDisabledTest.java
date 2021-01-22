package com.seleniumeasy.tests.inputforms.jquerydropdown;

import com.seleniumeasy.inputforms.DropdownDisabled;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.attribute;
import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class DropdownDisabledTest extends SettingsSeleniumEasy {

    DropdownDisabled dropdownDisabled = new DropdownDisabled();

    @Test
    public void testSelectTerritoryByName() throws Exception {
        dropdownDisabled
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownDisabled.class)
                .selectTerritoryByName("Puerto Rico")
                .validateDisplayedTerritory(attribute("title", "Puerto Rico"));
    }

    @Test
    public void testSelectTerritoryByIndex() throws Exception {
        dropdownDisabled
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownDisabled.class)
                .selectTerritoryByIndex(5)
                .validateDisplayedTerritory(5);
    }
}