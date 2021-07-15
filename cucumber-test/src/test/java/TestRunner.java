import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Multiply1", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/cucumber.json"}, glue = "com",
        dryRun = false,
        features = "src/main/resources/features/")
public class TestRunner {

}