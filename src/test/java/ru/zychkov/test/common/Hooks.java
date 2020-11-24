package ru.zychkov.test.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    Logger LOG = LogManager.getLogger(Hooks.class);

    @Before
    public void setupBrowser() {
        Configuration.browser = Config.getInstance().getBrowser();
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
    }

    @After
    public void logOut(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Screenshots.takeScreenShotAsFile();
                assert (screenshot != null);
                InputStream targetStream = new FileInputStream(screenshot);
                Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
            } catch (IOException e) {
                LOG.log(Level.ERROR, e);
            }
        }

//        open(Config.getInstance().getHostName() + "/c/portal/logout");
//        closeWindow();
    }
}