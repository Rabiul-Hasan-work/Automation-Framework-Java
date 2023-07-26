package utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@PropertySource("/framework.properties")
public class ConfigurationProperties {

    @Value("${browser}")
    private String browser;
    @Value("${email}")
    private String email;
    @Value("${password}")
    private String password;
    @Value("${NameOnCard}")
    private String NameOncard;
    @Value("${cardNumber}")
    private String cardNumber;
    @Value("${cvc}")
    private String cvc;
    @Value("${expirationMM}")
    private String expirationMM;
    @Value("${expirationYY")
    private String expirationYY;
    @Value("${username}")
    private String username;


}
