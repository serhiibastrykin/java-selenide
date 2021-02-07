package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class SimpleFormDemoPage extends BasePage {
    private final SelenideElement fieldEnterMessage = $("#user-message"),
            buttonShowMessage = $("#get-input .btn-default"),
            firstNumberField = $("#sum1"),
            secondNumberField = $("#sum2"),
            buttonGetTotal = $("#gettotal .btn-default"),
            totalDisplayed = $("#displayvalue"),
            messageDisplayed = $("#display");

    public SimpleFormDemoPage enterYourMessage(String message) {
        fieldEnterMessage.setValue(message);
        return this;
    }

    public SimpleFormDemoPage clickShowMessageButton() {
        buttonShowMessage.click();
        return this;
    }

    public void validateDisplayedMessage(Condition c) {
        messageDisplayed.should(c);
    }

    public SimpleFormDemoPage enterFirstNumber(String firstNumber) {
        firstNumberField.setValue(firstNumber);
        return this;
    }

    public SimpleFormDemoPage enterSecondNumber(String secondNumber) {
        secondNumberField.setValue(secondNumber);
        return this;
    }

    public static String addTwoNumbers(String firstNumber, String secondNumber) {
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int sum = num1 + num2;
        return String.valueOf(sum);
    }

    public SimpleFormDemoPage clickGetTotalButton() {
        buttonGetTotal.click();
        return this;
    }

    public void validateTotalDisplayed(String result) {
        totalDisplayed.shouldHave(exactText(result));
    }
}