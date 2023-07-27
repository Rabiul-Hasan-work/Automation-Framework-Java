package automation;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.cucumber.picocontainer.PicoFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        features = "src/main/resources/features",
        objectFactory = PicoFactory.class // Use PicoFactory for dependency injection
)
public class RunTests {
    @Test
    public void tests() {

    }
}
