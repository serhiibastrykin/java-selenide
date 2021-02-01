package com.seleniumeasy.tests.inputforms;

import com.seleniumeasy.inputforms.InputFormSubmitPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.INPUT_FORM_SUBMIT;

/**
 * All fields except "Website or domain name" and "Do you have hosting?" are required.
 * The answer for the "Do you have hosting?" field can be either "yes" or "no" (lowercase only).
 *
 * @author Serhii Bastrykin
 */

public class InputFormSubmitTest extends SettingsSeleniumEasy {

    InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage();

    @Test
    public void testInputFormWithValidations() throws Exception {
        inputFormSubmitPage
                .openInputForms(INPUT_FORM_SUBMIT, InputFormSubmitPage.class)
                .enterFirstName("Serhii")
                .enterLastName("Bastrykin")
                .enterEmail("sbast@gmail.com")
                .enterPhone("0930009999")
                .enterAddress("Sacramento")
                .enterCity("Los Angeles")
                .selectState("California")
                .enterZipCode("76026")
                .enterWebsiteOrDomainName("sb.com")
                .doYouHaveHosting("no")
                .enterProjectDescription("description")
                .clickSend()
                .verifyFormIsSubmitted();
    }
}