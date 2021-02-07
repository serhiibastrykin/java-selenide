package utils;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static com.seleniumeasy.enums.statics.FileTypes.*;
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
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.panel.shown", false);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("security.mixed_content.block_active_content", false);
        profile.setPreference("security.mixed_content.block_display_content", false);

        FirefoxOptions options = new FirefoxOptions()
                .setProfile(profile)
                .setBinary(binary)
                .setLegacy(false);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}