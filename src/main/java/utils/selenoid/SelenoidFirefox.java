package utils.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidFirefox implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        DesiredCapabilities browser = DesiredCapabilities.firefox();
        browser.setBrowserName("firefox");
        browser.setVersion("83");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);

        try {
            return new RemoteWebDriver(
                    new URL("http://192.168.0.101:4444/wd/hub"),
                    browser
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}