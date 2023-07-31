package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ProductPage;
import automation.pages.SignInAndSignOutPage;
import automation.utils.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
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
    ExtentTest test;
    static ExtentReports report = new ExtentReports("report/TestReport.html");


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
        TestCases[] tests = TestCases.values();
        test = report.startTest(tests[Utils.testCount].getTestName());
        Log.getLogData(Log.class.getName());
        Log.startTest(tests[Utils.testCount].getTestName());
        Utils.testCount++;
    }

    @Given("^I go to the website")
    public void iGoToTheWebsite() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        Log.info("INFO: Navigating to " + Constants.URL);
        test.log(LogStatus.PASS, "Navigating to " + Constants.URL);

    }

    @When("^I click on Sign In button")
    public void iClickOnSignInButton() {
        homePage.clickLogIn();
        test.log(LogStatus.PASS, "Sign In button has been clicked.");

    }

    @And("^I specify my credentials and click Login")
    public void iSpecifyMyCredentialsAndClickLogin() {
        signInAndSignOutPage.login(configurationProperties.getEmail(), configurationProperties.getPassword());
        test.log(LogStatus.PASS, "Login has been clicked.");

    }

    @Then("^I can log into the website")
    public void iCanLogIntoTheWebsite() {
        if (configurationProperties.getUsername().equals(homePage.getUserName())) {
            Log.info("INFO: The authentication is successful.");
            test.log(LogStatus.PASS, "The authentication is successful.");
        } else {
            Log.error("ERROR: Authentication is not successful.");
            test.log(LogStatus.FAIL, "Authentication is not successful.");
        }
        assertEquals(configurationProperties.getUsername(), homePage.getUserName());
    }

    @When("I add element to the cart")
    public void iAddElementToTheCart() {
        homePage.addTestUnitFirstELement();
        test.log(LogStatus.PASS, "Two elements were added to the cart");
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {

        checkoutPage.goToCheckout();
        test.log(LogStatus.PASS, "We proceed to checkout");
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
        test.log(LogStatus.PASS, "We confirm the final order");
    }

    @Then("The elements are bought")
    public void theElementsAreBought() {
        if (checkoutPage.checkFinalStatus()) {
            Log.info("INFO: The items are bought.");
            test.log(LogStatus.PASS, "The items are bought.");
        } else {
            Log.error("ERROR: The items weren't bought.");
            test.log(LogStatus.FAIL, "The items weren't bought.");
        }
        assertTrue(checkoutPage.checkFinalStatus());
    }

    @After
    public void closeObjects(){
        report.endTest(test);
        report.flush();
        DriverSingleton.closeObjectInstance();
    }

}
