package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
}
