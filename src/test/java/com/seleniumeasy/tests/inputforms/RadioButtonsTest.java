package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.RadioButtonsDemoPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.RADIO_BUTTONS_DEMO;

public class RadioButtonsTest extends SettingsSeleniumEasy {
    private final String selectedGender = "Male",
            selectedAgeGroup = "15 - 50";

    RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage();

    @Test
    public void testGroupRadioButtons() {
        radioButtonsDemoPage
                .openInputForms(RADIO_BUTTONS_DEMO, RadioButtonsDemoPage.class)
                .selectGender()
                .selectAgeGroup()
                .clickGetValues()
                .validateDisplayedInformation(selectedGender, selectedAgeGroup);
    }
}