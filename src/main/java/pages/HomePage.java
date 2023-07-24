package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Utils;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > a")
    private WebElement addToCartFirst;
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.product-overlay > div > a")
    private WebElement addToCartSecond;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a")
    private WebElement cart;
    @FindBy(css = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a")
    private WebElement viewCart;
    @FindBy(css = "#cart_info_table > thead > tr > td.image")
    private WebElement cartTable;
    @FindBy(css = "#do_action > div.container > div > div > a")
    private WebElement proceedToCheckButton;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement continueShoppingButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-4 > div > a > img")
    private WebElement homePageIcon;
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center")
    private WebElement firstElement;
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center")
    private WebElement secondElement;
    @FindBy(css = "#checkoutModal > div > div > div.modal-footer > button")
    private WebElement continueToCart;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
    private WebElement logInButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a")
    private WebElement userName;

    public void clickLogIn() {
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }


    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        cart.click();
        if(cartTable.isDisplayed())
            System.out.println("Cart has been updated");
        else
            System.out.println("Cart has not been updated");
        homePageIcon.click();
    }

    public void addTestUnitFirstELement() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        cart.click();
        if(cartTable.isDisplayed())
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
            Utils.takeScreenshot();
        }
//        homePageIcon.click();
    }

    public void addSecondElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(secondElement).build().perform();
        addToCartSecond.click();
        continueShoppingButton.click();
        cart.click();
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckButton));
        proceedToCheckButton.click();
        continueToCart.click();
    }
}
