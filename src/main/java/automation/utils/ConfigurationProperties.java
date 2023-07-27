package automation.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Getter
//@Setter
//@Component
@PropertySource(value = "classpath:framework.properties")
public class ConfigurationProperties {

    private String browser = "drivers.strategies.Chrome";
    private String email = "rabiulworkapps@gmail.com";
    private String password = "setara9";
    private String NameOncard = "Your Name";
    private String cardNumber = "1234 5678 9101 1121";
    private String cvc = "123";
    private String expirationMM = "12";
    private String expirationYY = "25";
    private String username = "Logged in as Naim Hasan";

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameOncard() {
        return NameOncard;
    }

    public void setNameOncard(String nameOncard) {
        NameOncard = nameOncard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpirationMM() {
        return expirationMM;
    }

    public void setExpirationMM(String expirationMM) {
        this.expirationMM = expirationMM;
    }

    public String getExpirationYY() {
        return expirationYY;
    }

    public void setExpirationYY(String expirationYY) {
        this.expirationYY = expirationYY;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
