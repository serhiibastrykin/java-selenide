package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

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
    public void cleanUp() {
        closeWindow();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}