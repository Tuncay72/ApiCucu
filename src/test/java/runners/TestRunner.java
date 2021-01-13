package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = "json:target/jsonReport/cucumber-report.java",
        glue = "stepDefinations"   ,
        dryRun = false,
        tags = "@DeletePlace"
       
)
public class TestRunner {

}
