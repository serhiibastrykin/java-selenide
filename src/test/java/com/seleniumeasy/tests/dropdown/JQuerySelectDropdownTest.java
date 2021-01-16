package com.seleniumeasy.tests.dropdown;

import com.seleniumeasy.inputforms.JQuerySelectDropdownPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.attribute;
import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class JQuerySelectDropdownTest extends SettingsSeleniumEasy {
    private final String territory = "Puerto Rico";

    JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage();

    @Test
    public void testSelectTerritoryByName() throws Exception {
        jQuerySelectDropdownPage
                .openInputForms(JQUERY_SELECT_DROPDOWN, JQuerySelectDropdownPage.class)
                .selectTerritoryByName(territory)
                .validateDisplayedOption(attribute("title", territory));
    }

    @Test
    public void testSelectTerritoryByIndex() throws Exception {
        jQuerySelectDropdownPage
                .openInputForms(JQUERY_SELECT_DROPDOWN, JQuerySelectDropdownPage.class)
                .selectTerritoryByIndex(5)
                .validateDisplayedOption(5);
    }
}