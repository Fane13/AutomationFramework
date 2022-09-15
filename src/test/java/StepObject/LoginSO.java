package StepObject;

import PageObject.HomePO;
import PageObject.LoginPO;
import Utils.BaseClass;
import Utils.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;


public class LoginSO extends BaseClass {
    LoginPO loginPO = new LoginPO();
    HomePO homePO = new HomePO();
    Configuration config = new Configuration();

    public LoginSO(WebDriver driver, WebDriverWait wait) throws IOException, ParseException {
        super(driver, wait);

    }

    public void navigateToLogin() {
        driver.get(config.getUrl());
        click(homePO.getSignInButton());
    }

    public void login(String username, String password) {
        writeText(loginPO.getEmailInput(), username);
        writeText(loginPO.getPasswordInput(), password);
        click(loginPO.getSubmitButton());
    }

    public void checkAdmin() {
        assertEquals(homePO.getAdminButton(), "ADMIN");
    }

    public void checkMessageToaster(String expected) {
        assertEquals(loginPO.getToaster(), expected);
    }

    public void checkErrorMessage(String expected) {
        Assert.assertEquals($(loginPO.getInvalidMessage()).getText(), expected);
    }

    public Configuration getConfig() {
        return config;
    }
}
