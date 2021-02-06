package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SettingsTusDemo {
    private final String base_URL = "https://tus.io/demo.html";

    @BeforeClass
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void openWebsite() {
        open(base_URL);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}