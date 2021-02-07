package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.RadioButtonsDemoPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.InputForms.RADIO_BUTTONS_DEMO;

public class RadioButtonsTest extends BaseTest {
    private final String gender = "Male",
            ageGroup = "15 - 50";

    RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage();

    @Test
    public void testGroupRadioButtons() {
        radioButtonsDemoPage
                .openInputForms(RADIO_BUTTONS_DEMO, RadioButtonsDemoPage.class)
                .selectGender(gender)
                .selectAgeGroup(ageGroup)
                .clickGetValues()
                .validateDisplayedInformation(text(gender), text(ageGroup));
    }
}