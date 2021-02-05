package utils;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;

public class FirefoxDriverProvider implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        WebDriverManager.firefoxdriver().browserVersion("83").setup();
        FirefoxBinary binary = new FirefoxBinary();
        binary.setTimeout(90000);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", DOWNLOAD_DIR);
        profile.setPreference("browser.download.useDownloadDir", DOWNLOAD_DIR);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("security.mixed_content.block_active_content", false);
        profile.setPreference("security.mixed_content.block_display_content", false);
        FirefoxOptions options = new FirefoxOptions()
                .setProfile(profile)
                .setBinary(binary);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return new FirefoxDriver(options);
    }
}