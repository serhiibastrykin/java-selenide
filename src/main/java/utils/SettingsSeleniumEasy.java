package utils;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;

import static com.seleniumeasy.DemoHomePage.buttonClosePopup;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class SettingsSeleniumEasy {
    private final String BASE_URL = "https://www.seleniumeasy.com/test/";
    public final static String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "target";

    @BeforeClass
    public static void setUp() {
        Configuration.browser = ChromeDriverProvider.class.getName();
        Configuration.startMaximized = true;
    }

    @Before
    public void openWebsite() {
        open(BASE_URL);
        buttonClosePopup.click();
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
