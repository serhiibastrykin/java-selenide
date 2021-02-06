package utils.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;
import static utils.SettingsSeleniumEasy.selenoid_URL;

public class SelenoidChrome implements WebDriverProvider {

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.addArguments("--test-type");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        return options;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        DesiredCapabilities browser = DesiredCapabilities.chrome();
        browser.setBrowserName("chrome");
        browser.setVersion("88");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        browser.setCapability("download.default_directory", DOWNLOAD_DIR);
        browser.setCapability("safebrowsing.enabled", true);
        browser.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        browser.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());

        try {
            return new RemoteWebDriver(
                    new URL(selenoid_URL),
                    browser
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}