package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/F05SeleniumLinks.feature",
                    glue = "com.StepDefinition")
public class R05SeleniumLinks {
}
