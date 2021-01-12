package com.seleniumeasy.tests.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

import static com.seleniumeasy.inputforms.SimpleFormDemoPage.addTwoNumbers;

public class AdditionTest extends SettingsSeleniumEasy {
    private final String FIRST_NUMBER = "25",
            SECOND_NUMBER = "23";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void addTwoNumbersTest() {
        simpleFormDemoPage
                .clickStartPractisingButton()
                .openSimpleFormDemo()
                .enterFirstNumber(FIRST_NUMBER)
                .enterSecondNumber(SECOND_NUMBER)
                .clickGetTotalButton()
                .validateTotalDisplayed(addTwoNumbers(FIRST_NUMBER, SECOND_NUMBER));
    }
}
