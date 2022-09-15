package Tests;

import Utils.SeleniumHelper;
import org.testng.annotations.Test;

public class NewOrganisationTest extends SeleniumHelper {

    @Test(priority = 1)
    public void loginToAdmin() {
        loginSO.navigateToLogin();
        loginSO.login(loginSO.getConfig().getUsername(), loginSO.getConfig().getPassword());
        loginSO.checkAdmin();
    }

    @Test(priority = 2, dependsOnMethods = "loginToAdmin")
    public void goToNewOrgPage() {
        organizationSO.goToNewOrgPage();
    }

    @Test(priority = 3, dependsOnMethods = "goToNewOrgPage")
    public void completeNewOrgForm() {
        organizationSO.completeFirstPage();
        organizationSO.uploadOrganisationLogo();
        organizationSO.uploadOrganizationImage();
        organizationSO.completeSecondPage();
        organizationSO.completeThirdPage();
        organizationSO.completeFinancialYear();
        organizationSO.submitOrganbisation();
    }

    @Test(priority = 4, dependsOnMethods = "completeNewOrgForm")
    public void checkOrgStatusPending() {
        organizationSO.checkPendingStatus();
    }

    @Test(priority = 5, dependsOnMethods = "checkOrgStatusPending")
    public void makeNewOrgLive() {
        organizationSO.makeLive();
    }

    @Test(priority = 6, dependsOnMethods = "makeNewOrgLive")
    public void checkOrgStatusLive() {
        organizationSO.checklLiveStatus();
    }
}
