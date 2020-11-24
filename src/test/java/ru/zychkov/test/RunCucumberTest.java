package ru.zychkov.test;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.junit.Courgette;

import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 4,
        runLevel = CourgetteRunLevel.FEATURE,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        reportTargetDir = "build",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "",
                tags = {"@KZ"},
                plugin = {
                        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                        "pretty",
                        "summary"}))
public class RunCucumberTest {
}