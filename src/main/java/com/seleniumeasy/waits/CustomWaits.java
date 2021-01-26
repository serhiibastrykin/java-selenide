package com.seleniumeasy.waits;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CustomWaits {

    public static void waitForFile(File file) {
        Wait<WebDriver> wait = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        wait.until((f) -> file.exists());
    }

    public static void waitUntilAlertMessageDisappears(SelenideElement element, int duration) {
        Wait<WebDriver> wait = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.attributeToBe(element, "style", "display: none;"));
    }
}