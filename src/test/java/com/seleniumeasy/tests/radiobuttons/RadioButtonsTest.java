package com.seleniumeasy.tests.radiobuttons;

import com.seleniumeasy.inputforms.RadioButtonsDemoPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

public class RadioButtonsTest extends SettingsSeleniumEasy {
    private final String SELECTED_GENDER = "Male",
            SELECTED_AGE_GROUP = "15 - 50";

    RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage();

    @Test
    public void groupRadioButtons() {
        radioButtonsDemoPage
                .clickInputFormsDropdown1()
                .openRadioButtons()
                .selectGender()
                .selectAgeGroup()
                .clickGetValues()
                .validateDisplayedInformation(SELECTED_GENDER, SELECTED_AGE_GROUP);
    }
}
