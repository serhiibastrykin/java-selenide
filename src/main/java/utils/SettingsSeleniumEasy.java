package utils;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.selenoid.SelenoidChrome;
import utils.selenoid.SelenoidFirefox;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.seleniumeasy.DemoHomePage.BUTTON_CLOSE_POPUP;

public class SettingsSeleniumEasy {
    public final static String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "target";
    private final String baseURL = "https://www.seleniumeasy.com/test/";
    public static String browser = System.getProperty("Browser", "chrome");

    private static void setDriver(String browserTypeString) {
        if (browserTypeString == null)
            Assert.fail("Browser is not specified!");
        switch (browserTypeString) {
            case "selenoid_firefox":
                Configuration.browser = SelenoidFirefox.class.getName();
                break;
            case "chrome":
                Configuration.browser = ChromeDriverProvider.class.getName();
                break;
            case "selenoid_chrome":
                Configuration.browser = SelenoidChrome.class.getName();
                break;
            default:
                Assert.fail("Cannot find browser " + browserTypeString);
        }
    }

    @BeforeClass
    public void setUp() {
        setDriver(browser);
        System.out.println(browser);
//        setUpBaseConfig("chrome");
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void openWebsite() {
        open(baseURL);
        BUTTON_CLOSE_POPUP.click();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}