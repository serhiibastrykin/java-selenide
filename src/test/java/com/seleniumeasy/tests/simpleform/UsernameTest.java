package com.seleniumeasy.tests.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

public class UsernameTest extends SettingsSeleniumEasy {
    private final String MESSAGE = "Serhii Bastrykin";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void enterMessage() {
        simpleFormDemoPage
                .clickInputFormsDropdown1()
                .openSimpleFormDemo1()
                .enterYourMessage(MESSAGE)
                .clickShowMessageButton()
                .validateDisplayedMessage(MESSAGE);
    }
}
