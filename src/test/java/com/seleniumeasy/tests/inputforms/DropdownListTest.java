package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.SelectDropdownListPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.InputForms.SELECT_DROPDOWN_LIST;

public class DropdownListTest extends BaseTest {

    SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage();

    @Test
    public void selectDayByName() {
        selectDropdownListPage
                .openInputForms(SELECT_DROPDOWN_LIST, SelectDropdownListPage.class)
                .selectDayByName("Saturday")
                .validateDisplayedDay(text("Saturday"));
    }

    @Test
    public void selectDayByIndex() {
        selectDropdownListPage
                .openInputForms(SELECT_DROPDOWN_LIST, SelectDropdownListPage.class)
                .selectDayByIndex(4)
                .validateDisplayedDay(text("Wednesday"));
    }
}