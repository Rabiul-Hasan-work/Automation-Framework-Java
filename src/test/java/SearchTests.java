import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SignInAndSignOutPage;
import utils.Constants;
import utils.FrameworkProperties;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class SearchTests {
    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInAndSignOutPage signInAndSignOutPage;
    static CheckoutPage checkoutPage;
    static ProductPage productPage;
    static String inputString;
    static Boolean expectedResult;

    @BeforeClass
    public static void initializeObjects() {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance((frameworkProperties.getProperty(Constants.BROWSER)));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInAndSignOutPage = new SignInAndSignOutPage();
        checkoutPage = new CheckoutPage();
        productPage = new ProductPage();
    }

    public SearchTests(String inputString, Boolean expectedResult) {
        SearchTests.inputString = inputString;
        SearchTests.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Collection searchOptions() {
        return Arrays.asList(new Object[][] {
                { "TSHIRTS", true },
                { "JEANS", true },
                { "DRESS", true },
                { "", false },
                { "test", false }
        });
    }

    @Test
    public void testingSearch() {
        driver.get(Constants.PRODUCTION_URL);
//        productPage.gotoProductionPage();
        assertEquals(expectedResult, productPage.searchElement(inputString));
    }

    @AfterClass
    public static void closeObjects() {
        driver.close();
    }
}
