package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SettingsJQueryUI {
    private final String baseURL = "http://jqueryui.com/resources/demos/sortable/connect-lists.html";

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void openWebsite() {
        open(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}