package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.AjaxFormSubmitPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;

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
                .verifyLoadingIconIsDisplayed()
                .validateDisplayedMessage(exactText(message));
    }
}