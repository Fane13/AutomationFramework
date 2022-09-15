package StepObject;


import PageObject.LoginPO;
import PageObject.MyAccountPO;
import PageObject.RegisterPO;
import Utils.BaseClass;
import Utils.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Random;

public class RegisterSO extends BaseClass {
    RegisterPO registerPO = new RegisterPO();
    LoginPO loginPO = new LoginPO();

    MyAccountPO myAccountPO = new MyAccountPO();
    Configuration config = new Configuration();
    private final String newUser;

    public RegisterSO(WebDriver driver, WebDriverWait wait) throws IOException, ParseException {
        super(driver, wait);
        newUser = "fane" + new Random().nextInt(99999) + "@faneteam.testinator.com";
    }

    public Configuration getConfig() {
        return config;
    }

    public String getNewUser() {
        return newUser;
    }

    public void completeRegisterForm() {
        click(loginPO.getGoToRegister());
        writeText(registerPO.getEmailInput(), newUser);
        writeText(registerPO.getFirstNameInput(), "tester");
        writeText(registerPO.getLastNameInput(), "tester");
        writeText(registerPO.getPasswordInput(), config.getPassword());
        writeText(registerPO.getConfirmPasswordInput(), config.getPassword());
        click(registerPO.getRegisterButton());
        waitVisibility(loginPO.getGoToRegister());

    }

    public void completePrivacyModal() {
        waitVisibility("userType_1");
        $(registerPO.getDonorTypeRadio()).click();
        click(registerPO.getCodeOfConductCheck());
        click(registerPO.getTermsAndPrivacyCheck());
        click(registerPO.getModalCompleteRegistration());

    }

    public void uploadPhoto() {
        click(myAccountPO.getCropModal());
        $(myAccountPO.getBrowseFile()).sendKeys(config.getProfilePicture());
        click(myAccountPO.getUploadImageButton());
    }
    public void completeProfileInformation(String expected){
        writeText(myAccountPO.getAdressInput(),"Strada Brazilor 22, Brașov, Romania");
        writeText(myAccountPO.getJobTitleInput(),"Tester");
        writeText(myAccountPO.getBioInput(),"test");
        click(myAccountPO.getAdressInput());
        waitTime(1000);
        $(myAccountPO.getAdressInput()).sendKeys(Keys.ARROW_DOWN);
        waitTime(500);
        $(myAccountPO.getAdressInput()).sendKeys(Keys.ENTER);
        waitTime(500);
        click(myAccountPO.getSaveProfileButton());
        waitVisibility(myAccountPO.getCompletedProfileVisible());
        Assert.assertEquals($(myAccountPO.getCompletedProfileBanner()).getText(),expected);
    }
}
