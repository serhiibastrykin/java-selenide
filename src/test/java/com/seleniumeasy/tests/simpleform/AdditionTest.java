package com.seleniumeasy.tests.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

public class AdditionTest extends SettingsSeleniumEasy {
    private final String FIRST_NUMBER = "25",
            SECOND_NUMBER = "23";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void addTwoNumbersTest() {
        simpleFormDemoPage
                .clickStartPractisingButton()
                .openSimpleFormDemo2()
                .enterFirstNumber(FIRST_NUMBER)
                .enterSecondNumber(SECOND_NUMBER)
                .clickGetTotalButton()
                .validateTotalDisplayed(addTwoNumbers());
    }

    private String addTwoNumbers() {
        int number1 = Integer.parseInt(FIRST_NUMBER);
        int number2 = Integer.parseInt(SECOND_NUMBER);
        int sum = number1 + number2;
        return String.valueOf(sum);
    }
}
