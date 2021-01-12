package com.seleniumeasy.inputforms;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class SimpleFormDemoPage extends DemoHomePage {
    private final SelenideElement FIELD_ENTER_MESSAGE = $("#user-message"),
            BUTTON_SHOW_MESSAGE = $("#get-input .btn-default"),
            FIRST_NUMBER_FIELD = $("#sum1"),
            SECOND_NUMBER_FIELD = $("#sum2"),
            BUTTON_GET_TOTAL = $("#gettotal .btn-default"),
            TOTAL_DISPLAYED = $("#displayvalue"),
            MESSAGE_DISPLAYED = $("#display");

    public SimpleFormDemoPage enterYourMessage(String yourMessage) {
        FIELD_ENTER_MESSAGE.setValue(yourMessage);
        return this;
    }

    public SimpleFormDemoPage clickShowMessageButton() {
        BUTTON_SHOW_MESSAGE.click();
        return this;
    }

    public void validateDisplayedMessage(String message) {
        MESSAGE_DISPLAYED.shouldHave(exactText(message));
    }

    public SimpleFormDemoPage enterFirstNumber(String yourFirstNumber) {
        FIRST_NUMBER_FIELD.setValue(yourFirstNumber);
        return this;
    }

    public SimpleFormDemoPage enterSecondNumber(String yourSecondNumber) {
        SECOND_NUMBER_FIELD.setValue(yourSecondNumber);
        return this;
    }

    public static String addTwoNumbers(String firstNum, String secondNum) {
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
        int sum = num1 + num2;
        return String.valueOf(sum);
    }

    public SimpleFormDemoPage clickGetTotalButton() {
        BUTTON_GET_TOTAL.click();
        return this;
    }

    public void validateTotalDisplayed(String result) {
        TOTAL_DISPLAYED.shouldHave(exactText(result));
    }
}