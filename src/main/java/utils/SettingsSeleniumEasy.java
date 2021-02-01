package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import static com.seleniumeasy.DemoHomePage.BUTTON_CLOSE_POPUP;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class SettingsSeleniumEasy {
    public final static String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "target";
    private final String baseURL = "https://www.seleniumeasy.com/test/";

    @BeforeClass
    public void setUp() {
        Configuration.browser = ChromeDriverProvider.class.getName();
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void openWebsite() {
        open(baseURL);
        BUTTON_CLOSE_POPUP.click();
    }

    @AfterMethod
    public void cleanUp() {
        clearBrowserCache();
        clearBrowserCookies();
        closeWindow();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}