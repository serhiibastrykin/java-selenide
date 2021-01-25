package utils;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;

import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;

public class ChromeDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {

        WebDriverManager.chromedriver().browserVersion("88").setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", DOWNLOAD_DIR);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("password_manager_enabled", false);
        chromePrefs.put(CapabilityType.ACCEPT_SSL_CERTS, true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--no-sandbox");
        options.addArguments("--test-type");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");

        return new ChromeDriver(options);
    }
}