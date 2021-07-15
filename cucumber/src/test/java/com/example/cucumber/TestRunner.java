package com.example.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Post", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/cucumber.json"}, glue = "com.example.cucumber",
        dryRun = false,
        features = "src/test/resources/features/")
public class TestRunner {

}