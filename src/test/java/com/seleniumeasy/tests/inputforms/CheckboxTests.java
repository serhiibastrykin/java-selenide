package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.CheckboxDemoPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.CHECKBOX_DEMO;

public class CheckboxTests extends SettingsSeleniumEasy {
    private final String nameBefore = "Check All",
            nameAfter = "Uncheck All";
    private final boolean valueBefore = false,
            valueAfter = true;

    CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage();

    @Test
    public void severalCheckboxes() {
        checkboxDemoPage
                .openInputForms(CHECKBOX_DEMO, CheckboxDemoPage.class)
                .checkSeveralCheckboxes()
                .verifyValueOfTheButton(valueBefore)
                .validateNameOfTheButton(nameBefore);
    }

    @Test
    public void allCheckboxes() {
        checkboxDemoPage
                .openInputForms(CHECKBOX_DEMO, CheckboxDemoPage.class)
                .checkAllCheckboxes()
                .verifyValueOfTheButton(valueAfter)
                .validateNameOfTheButton(nameAfter);
    }
}