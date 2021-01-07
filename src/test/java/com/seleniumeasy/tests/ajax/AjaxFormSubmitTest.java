package com.seleniumeasy.tests.ajax;

import com.seleniumeasy.inputforms.AjaxFormSubmitPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

public class AjaxFormSubmitTest extends SettingsSeleniumEasy {
    private final String NAME = "Serhii",
            COMMENT = "This is my comment.",
            MESSAGE = "Form submited Successfully!";

    AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage();

    @Test
    public void testAjaxFormSubmit() {
        ajaxFormSubmitPage
                .clickInputFormsDropdown2()
                .openAjaxFormSubmit()
                .enterName(NAME)
                .enterComment(COMMENT)
                .clickSubmitButton()
                .verifyDisplayedMessage(MESSAGE);
    }
}
