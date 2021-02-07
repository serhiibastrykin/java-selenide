package utils.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static com.seleniumeasy.enums.statics.FileTypes.*;
import static utils.BaseTest.DOWNLOAD_DIR;
import static utils.BaseTest.selenoid_URL;

public class SelenoidFirefox implements WebDriverProvider {

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", DOWNLOAD_DIR);
        profile.setPreference("browser.download.useDownloadDir", DOWNLOAD_DIR);
        String fileTypes = TXT.getType() + ", " + BINARY.getType() + ", "
                + PDF.getType() + ", " + CSV.getType() + ", " + JPEG.getType() + ", "
                + XML.getType() + ", " + EXCEL.getType() + ", " + PNG.getType() + ", "
                + JSON.getType() + ", " + DOCX.getType();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", fileTypes);
        profile.setPreference("browser.helperApps.neverAsk.openFile", fileTypes);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("security.mixed_content.block_active_content", false);
        profile.setPreference("security.mixed_content.block_display_content", false);
        return new FirefoxOptions().setProfile(profile);
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        DesiredCapabilities browser = DesiredCapabilities.firefox();
        browser.setBrowserName("firefox");
        browser.setVersion("83");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        browser.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());

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