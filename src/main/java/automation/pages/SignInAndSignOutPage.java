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

public class SignInAndSignOutPage {
    private WebDriver driver;

    public SignInAndSignOutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
    private WebElement emailLogInField;
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    private WebElement LoginButton;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)")
    private WebElement NameSignUp;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    private WebElement emailSignUpField;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > button")
    private WebElement signUpButton;
    @FindBy(css = "#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a")
    private WebElement loginRegisterPageButton;
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2")
    private WebElement loginRegisterConfirmationMessage;
    @FindBy(css = "#checkoutModal > div > div")
    private WebElement firstElement;
    @FindBy(css = "#checkoutModal > div > div > div.modal-footer > button")
    private WebElement continueToCart;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
    private WebElement singUpLoginPage;

    public void loginRegisterPage() {
//        Actions hover = new Actions(driver);
//        hover.moveToElement(firstElement).build().perform();
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(singUpLoginPage));
//        continueToCart.click();
        singUpLoginPage.click();
    }

    public Boolean checkLoginRegisterPageStatus() {
        int timeoutInSeconds = Constants.TIMEOUT;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(loginRegisterConfirmationMessage));
        return loginRegisterConfirmationMessage.getText().contains(Constants.LOGIN_PAGE);
    }

    public void login(String email, String password) {
        emailLogInField.sendKeys(email);
        this.password.sendKeys(password);
        LoginButton.click();
    }

    public void signUp(String name, String email) {
        NameSignUp.sendKeys(name);
        emailSignUpField.sendKeys(email);
        signUpButton.click();
    }
}
