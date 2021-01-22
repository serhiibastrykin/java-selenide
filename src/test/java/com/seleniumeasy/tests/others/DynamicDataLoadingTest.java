package com.seleniumeasy.tests.others;

import com.seleniumeasy.others.DynamicDataLoadingPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.text;

public class DynamicDataLoadingTest extends SettingsSeleniumEasy {

    DynamicDataLoadingPage dynamicDataLoadingPage = new DynamicDataLoadingPage();

    @Test
    public void testDynamicDataLoading() {
        dynamicDataLoadingPage
                .clickOthersDropdown()
                .openDynamicDataLoading()
                .clickGetNewUser()
                .verifyImageIsDisplayed()
                .validateDisplayedText(text("First Name"), text("Last Name"));
    }
}
