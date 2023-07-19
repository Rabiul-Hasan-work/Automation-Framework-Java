package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInAndSignOutPage {
    private WebDriver driver;

    public SignInAndSignOutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
    private WebElement emailLogInField;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    private WebElement password;
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")
    private WebElement LoginButton;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)")
    private WebElement NameSignUp;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    private WebElement emailSignUpField;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > button")
    private WebElement signUpButton;

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
