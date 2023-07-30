package automation.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Getter
//@Setter
@Getter
@Setter
@Service
@Component
@PropertySource("classpath:application.properties")
public class ConfigurationProperties {

    private String browser = "drivers.strategies.Chrome";
//    @Value("${browser}")
//    private String browser;
//    @Value("${email}")
//    private String email;

    private String email = "rabiulworkapps@gmail.com";
    private String password = "setara9@";
    private String NameOncard = "Your Name";
    private String cardNumber = "1234 5678 9101 1121";
    private String cvc = "123";
    private String expirationMM = "12";
    private String expirationYY = "25";
    private String username = "Logged in as Naim Hasan";

}
