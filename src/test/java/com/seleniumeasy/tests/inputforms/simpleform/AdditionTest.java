package com.seleniumeasy.tests.inputforms.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.BaseTest;
import org.testng.annotations.Test;

import static com.seleniumeasy.enums.InputForms.SIMPLE_FORM_DEMO;
import static com.seleniumeasy.inputforms.SimpleFormDemoPage.addTwoNumbers;

public class AdditionTest extends BaseTest {
    private final String firstNumber = "25",
            secondNumber = "23";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void addTwoNumbersTest() {
        simpleFormDemoPage
                .openInputForms(SIMPLE_FORM_DEMO, SimpleFormDemoPage.class)
                .enterFirstNumber(firstNumber)
                .enterSecondNumber(secondNumber)
                .clickGetTotalButton()
                .validateTotalDisplayed(addTwoNumbers(firstNumber, secondNumber));
    }
}