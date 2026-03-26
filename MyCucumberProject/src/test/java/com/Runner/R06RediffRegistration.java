package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/F06RediffRegistration.feature",
        glue = "com.StepDefinition")
public class R06RediffRegistration {
}
