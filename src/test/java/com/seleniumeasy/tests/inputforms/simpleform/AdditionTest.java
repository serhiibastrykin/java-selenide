package com.seleniumeasy.tests.inputforms.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

import static com.seleniumeasy.inputforms.SimpleFormDemoPage.addTwoNumbers;

public class AdditionTest extends SettingsSeleniumEasy {
    private final String firstNumber = "25",
            secondNumber = "23";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void addTwoNumbersTest() {
        simpleFormDemoPage
                .clickStartPractisingButton()
                .openSimpleFormDemo()
                .enterFirstNumber(firstNumber)
                .enterSecondNumber(secondNumber)
                .clickGetTotalButton()
                .validateTotalDisplayed(addTwoNumbers(firstNumber, secondNumber));
    }
}