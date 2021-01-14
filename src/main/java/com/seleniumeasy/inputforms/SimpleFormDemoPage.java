package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class SimpleFormDemoPage extends DemoHomePage {
    private final SelenideElement fieldEnterMessage = $("#user-message"),
            buttonShowMessage = $("#get-input .btn-default"),
            firstNumberField = $("#sum1"),
            secondNumberField = $("#sum2"),
            buttonGetTotal = $("#gettotal .btn-default"),
            totalDisplayed = $("#displayvalue"),
            messageDisplayed = $("#display");

    public SimpleFormDemoPage enterYourMessage(String yourMessage) {
        fieldEnterMessage.setValue(yourMessage);
        return this;
    }

    public SimpleFormDemoPage clickShowMessageButton() {
        buttonShowMessage.click();
        return this;
    }

    public void validateDisplayedMessage(String message) {
        messageDisplayed.shouldHave(exactText(message));
    }

    public SimpleFormDemoPage enterFirstNumber(String yourFirstNumber) {
        firstNumberField.setValue(yourFirstNumber);
        return this;
    }

    public SimpleFormDemoPage enterSecondNumber(String yourSecondNumber) {
        secondNumberField.setValue(yourSecondNumber);
        return this;
    }

    public static String addTwoNumbers(String firstNum, String secondNum) {
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
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