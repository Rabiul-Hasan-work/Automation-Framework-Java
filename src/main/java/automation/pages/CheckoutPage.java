package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Constants;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "head > title")
    private WebElement pageTittle;

    @FindBy(css = "#do_action > div.container > div > div > a")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "#cart_items > div > div:nth-child(7) > a")
    private WebElement placeOrderButton;
    @FindBy(id= "submit")
    private WebElement payAndConfirmOderButton;
    @FindBy(css = "#form > div > div > div > p")
    private WebElement orderConfirmationMessage;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a")
    private WebElement cart;
    @FindBy(css = "#payment-form > div:nth-child(2) > div > input")
    private WebElement NameOnCardField;
    @FindBy(css = "#payment-form > div:nth-child(3) > div > input")
    private WebElement cardNumberField;
    @FindBy(css = "#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")
    private WebElement cvcField;
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(2) > input")
    private WebElement expirationMMField;
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(3) > input")
    private WebElement expirationYYField;
    @FindBy(css = "#cart_info_table > thead > tr > td.image")
    private WebElement summaryProduct;

    public Boolean checkTitle(String title) {
        return pageTittle.getText().equals(title);
    }

    public void goToCheckout() {
        cart.click();
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }

    public void placeOrder() {
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
    }

    public void payAndConfirm(String NameOnCard, String cardNumber, String cvc, String expirationMM, String expirationYY) {
        NameOnCardField.sendKeys(NameOnCard);
        cardNumberField.sendKeys(cardNumber);
        cvcField.sendKeys(cvc);
        expirationMMField.sendKeys(expirationMM);
        expirationYYField.sendKeys(expirationYY);
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmOderButton));
        payAndConfirmOderButton.click();
    }

    public Boolean checkFinalStatus() {
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return orderConfirmationMessage.getText().contains(Constants.COMPLETE_ORDER);
    }

    public String getSummaryProductString() {
        return summaryProduct.getText();
    }
}
