package cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = "cucumber.stepDef",
        plugin = {"html:target/HTML_CheckoutProductReport.html"},
        tags = "@checkout"
)
public class runcheckout {
}
