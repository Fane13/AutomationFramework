package Tests;

import Utils.SeleniumHelper;
import org.testng.annotations.Test;

public class RegisterTest extends SeleniumHelper {
    @Test(priority = 1)
    public void completeRegisterForm() {
        loginSO.navigateToLogin();
        registerSO.completeRegisterForm();
    }

    @Test(priority = 2, dependsOnMethods = "completeRegisterForm")
    public void loginNewUser() {
        loginSO.login(registerSO.getNewUser(), registerSO.getConfig().getPassword());
    }

    @Test(priority = 3, dependsOnMethods = "loginNewUser")
    public void completeModal() {
        registerSO.completePrivacyModal();
    }

    @Test(priority = 4, dependsOnMethods = "completeModal")
    public void uploadProfilePhoto() {
        registerSO.uploadPhoto();
    }

    @Test(priority = 5, dependsOnMethods = "uploadProfilePhoto")
    public void completeProfileInformation() {
        registerSO.completeProfileInformation("Thank you for completing your profile! We will review it and get back to you soon.");
    }

}
