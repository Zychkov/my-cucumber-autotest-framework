package ru.zychkov.test.common;

import com.codeborne.selenide.WebDriverProvider;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidDriverProvider implements WebDriverProvider {

    Logger LOG = LogManager.getLogger(SelenoidDriverProvider.class);

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setBrowserName(Config.getInstance().getSelenoidBrowser());
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver driver = null;

        try {
            driver = new RemoteWebDriver(URI.create(Config.getInstance().getSelenoidHost()).toURL(), capabilities);
            driver.setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException exception) {
            LOG.log(Level.ERROR, exception);
        }

        assert (driver != null);

        return driver;
    }
}