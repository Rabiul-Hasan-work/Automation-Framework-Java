package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a")
    private WebElement productButton;
    @FindBy(css = "#search_product")
    private WebElement searchBar;
    @FindBy(css = "#submit_search")
    private WebElement searchButton;
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img")
    private WebElement searchResult;

    public void gotoProductionPage() {
        productButton.click();

    }
    public Boolean searchElement(String searchStr) {
//        productButton.click();
        searchBar.sendKeys(searchStr);
        searchButton.click();
        try {
            if (searchResult.isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
