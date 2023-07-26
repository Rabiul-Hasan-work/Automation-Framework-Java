package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ProductPage;
import automation.pages.SignInAndSignOutPage;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
//@RequiredArgsConstructor
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInAndSignOutPage signInAndSignOutPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;

    private DriverSingleton driverSingleton;


    @Autowired
    ConfigurationProperties configurationProperties;

//    private final ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects() {
        driverSingleton = DriverSingleton.getInstance(configurationProperties.getBrowser());
        homePage = new HomePage();
        signInAndSignOutPage = new SignInAndSignOutPage();
        checkoutPage = new CheckoutPage();
    }

    @Given("^I go to the website")
    public void i_go_to_the_website() {
        driver = driverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("^I click on Sign In button")
    public void i_click_on_sign_in_button() {
        homePage.clickLogIn();
    }

    @And("^I specify my credentials and click Login")
    public void i_specify_my_credentials_and_click_login() {
        signInAndSignOutPage.login(configurationProperties.getEmail(), configurationProperties.getPassword());
    }

    @Then("^I can log into the website")
    public void i_can_log_into_the_website() {
        assertEquals(configurationProperties.getUsername(),homePage.getUserName());
    }

}
