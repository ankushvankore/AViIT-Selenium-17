package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/F07OHRM_DataDrivenTesting.feature",
        glue = "com.StepDefinition")
public class R07OHRM_DataDrivenTesting {
}
