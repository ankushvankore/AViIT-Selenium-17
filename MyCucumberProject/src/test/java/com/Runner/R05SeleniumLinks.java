package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/F05SeleniumLinks.feature",
                    glue = "com.StepDefinition",
                    tags = "@AllTests",
                    publish = true)
public class R05SeleniumLinks {
    /*
    Execute Single Scenario:        tags = "@SmokeTest"
    Execute Multiple Scenarios:     tags = "@SmokeTest or @ProjectTest"
    Skip Single Scenario:           tags = "not @ProjectTest"
    Skip Multiple Scenarios:        tags = "not @ProjectTest and not @SupportTest"
     */
}
