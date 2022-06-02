import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//cucumber
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/AddToEntry.feature"},
        plugin = {"pretty",
                "html:target/cucumber-reports/report2.html"},
        publish = true)

public class CucumberTestsRunner2 {

}
