import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInAndSignOutPage;
import utils.Constants;
import utils.FrameworkProperties;

import static junit.framework.TestCase.assertEquals;

public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInAndSignOutPage signInAndSignOutPage;
    static CheckoutPage checkoutPage;

    @BeforeClass
    public static void initializeObjects() {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance((frameworkProperties.getProperty(Constants.BROWSER)));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInAndSignOutPage = new SignInAndSignOutPage();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testingAuthentication() {
        driver.get(Constants.URL);
        homePage.clickLogIn();
        signInAndSignOutPage.login(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUserName());
    }

    @AfterClass
    public static void CloseObject() {
        driver.close();
    }
}
