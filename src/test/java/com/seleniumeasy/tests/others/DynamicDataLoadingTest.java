package com.seleniumeasy.tests.others;

import com.seleniumeasy.others.DynamicDataLoadingPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.Others.DYNAMIC_DATA_LOADING;

public class DynamicDataLoadingTest extends BaseTest {

    DynamicDataLoadingPage dynamicDataLoadingPage = new DynamicDataLoadingPage();

    @Test
    public void testDynamicDataLoading() {
        dynamicDataLoadingPage
                .openOthers(DYNAMIC_DATA_LOADING, DynamicDataLoadingPage.class)
                .clickGetNewUser()
                .verifyImageIsDisplayed()
                .validateDisplayedText(text("First Name"), text("Last Name"));
    }
}
