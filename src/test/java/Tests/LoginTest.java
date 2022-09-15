package Tests;


import Utils.SeleniumHelper;
import org.testng.annotations.Test;


public class LoginTest extends SeleniumHelper {

    @Test(priority = 3)
    public void loginToAdmin() {
        loginSO.navigateToLogin();
        loginSO.login(loginSO.getConfig().getUsername(), loginSO.getConfig().getPassword());
        loginSO.checkAdmin();
    }

    @Test(priority = 2)
    public void invalidCredentials() {
        loginSO.navigateToLogin();
        loginSO.login("bad@email.com", "bad");
        loginSO.checkMessageToaster("Invalid email address or password");
    }
    @Test(priority = 1)
    public void noEmail() {
        loginSO.navigateToLogin();
        loginSO.login("", "bad");
        loginSO.checkErrorMessage("Email is required.");
    }
}
