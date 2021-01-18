package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.SelectDropdownListPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.InputForms.SELECT_DROPDOWN_LIST;

public class DropdownListTest extends SettingsSeleniumEasy {
    private final String day = "Saturday";

    SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage();

    @Test
    public void selectValueFromDropdown() {
        selectDropdownListPage
                .openInputForms(SELECT_DROPDOWN_LIST, SelectDropdownListPage.class)
                .selectDay(day)
                .validateDisplayedDay(text(day));
    }
}