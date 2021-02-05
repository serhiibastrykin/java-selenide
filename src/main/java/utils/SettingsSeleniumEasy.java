package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;
import utils.selenoid.SelenoidChrome;
import utils.selenoid.SelenoidFirefox;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.seleniumeasy.DemoHomePage.BUTTON_CLOSE_POPUP;
import static org.testng.xml.XmlSuite.ParallelMode.NONE;

public class SettingsSeleniumEasy {
    private final String baseURL = "https://www.seleniumeasy.com/test/";
    public final static String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "target";
    public static String browser = System.getProperty("Browser", "chrome");
    public static String parallel = System.getProperty("parallel", NONE.toString());

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
            case "firefox":
                Configuration.browser = FirefoxDriverProvider.class.getName();
                break;
            case "selenoid_chrome":
                Configuration.browser = SelenoidChrome.class.getName();
                break;
            default:
                Assert.fail("Cannot find browser " + browserTypeString);
        }
    }

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        context.getSuite().getXmlSuite().setParallel(XmlSuite.ParallelMode.getValidParallel(parallel));
    }

    @BeforeClass
    public void setUp() {
        setDriver(browser);
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void openWebsite() {
        open(baseURL);
        BUTTON_CLOSE_POPUP.click();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}