import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SignInAndSignOutPage;
import automation.utils.Constants;
import automation.utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://www.automationexercise.com/");
        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();

        SignInAndSignOutPage signInAndSignOutPage = new SignInAndSignOutPage();
        signInAndSignOutPage.loginRegisterPage();
        signInAndSignOutPage.checkLoginRegisterPageStatus();
        signInAndSignOutPage.login(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.goToCheckout();
        checkoutPage.placeOrder();
        checkoutPage.payAndConfirm(frameworkProperties.getProperty(Constants.NAME_ON_CARD), frameworkProperties.getProperty(Constants.CARD_NUMBER), frameworkProperties.getProperty(Constants.CVC), frameworkProperties.getProperty(Constants.EXPIRATION_MM), frameworkProperties.getProperty(Constants.EXPIRATION_YY));
        if (checkoutPage.checkFinalStatus())
            System.out.println("Test case completed!");


    }
}
