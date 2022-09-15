package Tests;

import Utils.SeleniumHelper;
import org.testng.annotations.Test;

public class NewGroupTest extends SeleniumHelper {
    @Test(priority = 1)
    public void loginToAdmin() {
        loginSO.navigateToLogin();
        loginSO.login(loginSO.getConfig().getUsername(), loginSO.getConfig().getPassword());
        loginSO.checkAdmin();
    }
    @Test(priority = 2,dependsOnMethods = "loginToAdmin")
    public void gotoNewGroupForm(){
        groupSO.goToMyGroups();
        groupSO.clickOnCreateGroup();
    }
    @Test(priority = 3,dependsOnMethods ="gotoNewGroupForm" )
    public void completeNewGroupForm(){
        groupSO.completeGroupForm();
    }
    @Test(priority = 4,dependsOnMethods = "completeNewGroupForm")
    public void submitNewGroup(){
        groupSO.submitEntity();
    }
}
