package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(

            features={"src/test/resources/features/FormAuthFeatures.feature", "src/test/resources/features/DynamicLoadingFeatures.feature"},
            glue = {"step_definitions"},
            plugin = {"html:target/cucumber-html-report"}
    )

public class Runner {

};
