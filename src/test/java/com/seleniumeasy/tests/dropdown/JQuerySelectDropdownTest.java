package com.seleniumeasy.tests.dropdown;

import com.seleniumeasy.inputforms.JQuerySelectDropdownPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.attribute;
import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class JQuerySelectDropdownTest extends SettingsSeleniumEasy {
    private final String territory1 = "Puerto Rico",
            territory2 = "Virgin Islands";

    JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage();

    @Test
    public void testSelectTerritoryByName() throws Exception {
        jQuerySelectDropdownPage
                .openInputForms(JQUERY_SELECT_DROPDOWN, JQuerySelectDropdownPage.class)
                .selectTerritoryByName(territory1)
                .validateDisplayedOption(attribute("title", territory1));
    }

    @Test
    public void testSelectTerritoryByIndex() throws Exception {
        jQuerySelectDropdownPage
                .openInputForms(JQUERY_SELECT_DROPDOWN, JQuerySelectDropdownPage.class)
                .selectTerritoryByIndex(5)
                .validateDisplayedOption(attribute("title", territory2));
    }
}