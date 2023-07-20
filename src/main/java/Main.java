import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInAndSignOutPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://www.automationexercise.com/");
        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
//        homePage.addSecondElementToCart();

        SignInAndSignOutPage signInAndSignOutPage = new SignInAndSignOutPage();
        signInAndSignOutPage.loginRegisterPage();
        signInAndSignOutPage.checkLoginRegisterPageStatus();
        signInAndSignOutPage.login(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.goToCheckout();


    }
}
