package automation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("automation.utils")
public class AutomationFrameworkConfiguration {
    public AutomationFrameworkConfiguration() {

    }
}
