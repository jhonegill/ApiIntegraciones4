package com.integraciones.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.integraciones"},
        tags = {"@integraciones"}
)
public class RunnerIntegraciones {
}
