package automation.glue;

import config.RunFrameworkConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SignInAndSignOutPage;
import utils.ConfigurationProperties;

@ContextConfiguration(classes = RunFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInAndSignOutPage signInAndSignOutPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;

    @Autowired
    ConfigurationProperties configurationProperties;
}
