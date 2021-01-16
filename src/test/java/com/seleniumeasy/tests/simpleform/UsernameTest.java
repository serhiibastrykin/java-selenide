package com.seleniumeasy.tests.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.InputForms.SIMPLE_FORM_DEMO;

public class UsernameTest extends SettingsSeleniumEasy {
    private final String message = "Serhii Bastrykin";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void enterMessage() {
        simpleFormDemoPage
                .openInputForms(SIMPLE_FORM_DEMO, SimpleFormDemoPage.class)
                .enterYourMessage(message)
                .clickShowMessageButton()
                .validateDisplayedMessage(exactText(message));
    }
}