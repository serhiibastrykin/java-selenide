package utils;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class SettingsTusDemo {
    private final String baseUrl = "https://tus.io/demo.html";

    @BeforeClass
    public static void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @Before
    public void openWebsite() {
        open(baseUrl);
    }

    @After
    public void cleanUp() {
        clearBrowserCache();
        clearBrowserCookies();
        closeWindow();
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }
}