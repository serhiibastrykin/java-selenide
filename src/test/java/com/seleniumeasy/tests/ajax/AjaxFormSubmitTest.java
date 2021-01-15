package com.seleniumeasy.tests.ajax;

import com.seleniumeasy.inputforms.AjaxFormSubmitPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

public class AjaxFormSubmitTest extends SettingsSeleniumEasy {
    private final String name = "Serhii",
            comment = "This is my comment.",
            message = "Form submited Successfully!";    //Bug on the page: typo in word "submitted"

    AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage();

    @Test
    public void testAjaxFormSubmit() {
        ajaxFormSubmitPage
                .clickInputFormsDropdown()
                .openAjaxFormSubmit()
                .enterName(name)
                .enterComment(comment)
                .clickSubmitButton()
                .verifyDisplayedMessage(message);
    }
}