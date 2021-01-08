package com.seleniumeasy.tests.checkbox;

import com.seleniumeasy.inputforms.CheckboxDemoPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.CHECKBOX_DEMO;

public class CheckboxTests extends SettingsSeleniumEasy {
    private final String NAME_OF_THE_BUTTON_BEFORE = "Check All",
            NAME_OF_THE_BUTTON_AFTER = "Uncheck All";
    private final boolean VALUE_OF_THE_BUTTON_BEFORE = false,
            VALUE_OF_THE_BUTTON_AFTER = true;

    CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage();

    @Test
    public void severalCheckboxes() {
        checkboxDemoPage
                .openInputForms(CHECKBOX_DEMO, CheckboxDemoPage.class)
                .checkSeveralCheckboxes()
                .verifyValueOfTheButton(VALUE_OF_THE_BUTTON_BEFORE)
                .validateNameOfTheButton(NAME_OF_THE_BUTTON_BEFORE);
    }

    @Test
    public void allCheckboxes() {
        checkboxDemoPage
                .openInputForms(CHECKBOX_DEMO, CheckboxDemoPage.class)
                .checkAllCheckboxes()
                .verifyValueOfTheButton(VALUE_OF_THE_BUTTON_AFTER)
                .validateNameOfTheButton(NAME_OF_THE_BUTTON_AFTER);
    }
}
