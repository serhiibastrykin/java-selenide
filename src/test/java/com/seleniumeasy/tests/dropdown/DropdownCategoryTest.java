package com.seleniumeasy.tests.dropdown;

import com.seleniumeasy.inputforms.DropdownCategory;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class DropdownCategoryTest extends SettingsSeleniumEasy {

    DropdownCategory dropdownCategory = new DropdownCategory();

    @Test
    public void testSelectFileByName() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileByName("Python")
                .validateDisplayedFile("Python");
    }

    @Test
    public void testSelectFileByIndex() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileByIndex(2, 1)
                .validateDisplayedFile("C");
    }

    @Test
    public void testSelectFileFromCategory() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileFromCategory("Programming languages", "Java")
                .validateDisplayedFile("Java");
    }
}