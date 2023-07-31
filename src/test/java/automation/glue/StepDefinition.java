package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ProductPage;
import automation.pages.SignInAndSignOutPage;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
//@RequiredArgsConstructor
@Service
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInAndSignOutPage signInAndSignOutPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;

    private DriverSingleton driverSingleton;


//    @Autowired
//    ConfigurationProperties configurationProperties;

    private final ConfigurationProperties configurationProperties;

//    @Autowired
    public StepDefinition(ConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @Before
    public void initializeObjects() {
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInAndSignOutPage = new SignInAndSignOutPage();
        checkoutPage = new CheckoutPage();
    }

    @Given("^I go to the website")
    public void iGoToTheWebsite() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("^I click on Sign In button")
    public void iClickOnSignInButton() {
        homePage.clickLogIn();
    }

    @And("^I specify my credentials and click Login")
    public void iSpecifyMyCredentialsAndClickLogin() {
        signInAndSignOutPage.login(configurationProperties.getEmail(), configurationProperties.getPassword());
    }

    @Then("^I can log into the website")
    public void iCanLogIntoTheWebsite() {
        assertEquals(configurationProperties.getUsername(),homePage.getUserName());
    }

    @When("I add element to the cart")
    public void iAddElementToTheCart() {
        homePage.addTestUnitFirstELement();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        checkoutPage.goToCheckout();
    }

    @And("I confirm address, place order and pay and confirm order")
    public void iConfirmAddressPlaceOrderAndPayAndConfirmOrder() {
        checkoutPage.goToCheckout();
        checkoutPage.placeOrder();
        checkoutPage.payAndConfirm(
                configurationProperties.getNameOncard(),
                configurationProperties.getCardNumber(),
                configurationProperties.getCvc(),
                configurationProperties.getExpirationMM(),
                configurationProperties.getExpirationYY());
    }

    @Then("The elements are bought")
    public void theElementsAreBought() {
        assertTrue(checkoutPage.checkFinalStatus());
    }

}
