package StepObject;

import PageObject.AdminPanelPO;
import PageObject.HomePO;
import PageObject.NewOrganizationPO;
import Utils.BaseClass;
import Utils.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Random;

public class OrganizationSO extends BaseClass {
    NewOrganizationPO newOrganizationPO = new NewOrganizationPO();
    HomePO homePO = new HomePO();
    AdminPanelPO adminPanelPO = new AdminPanelPO();

    Configuration config = new Configuration();
    private final String orgName = generateRandomOrganisationName();
    private final String makeLiveId = "changeStatus_" + orgName.toUpperCase();

    public OrganizationSO(WebDriver driver, WebDriverWait wait) throws IOException, ParseException {
        super(driver, wait);
    }

    public String generateRandomOrganisationName() {
        return "AorgTest" + new Random().nextInt(99999);

    }

    public void goToNewOrgPage() {
        click(homePO.getAdminButton());
        click(adminPanelPO.getNewOrgButton());
        try {
            click(adminPanelPO.getSelectLanguageButton());
        } catch (Exception ignore) {
        }
    }

    public void completeFirstPage() {
        writeText(newOrganizationPO.getOrgNameInput(), orgName);
        writeText(newOrganizationPO.getAddressInput(), "Brazilor 12");
        waitTime(1000);
        $(newOrganizationPO.getAddressInput()).sendKeys(Keys.ARROW_DOWN);
        waitTime(500);
        $(newOrganizationPO.getAddressInput()).sendKeys(Keys.ENTER);
        waitTime(500);
        writeText(newOrganizationPO.getPostalCodeInput(), "1234");
        writeText(newOrganizationPO.getWebsiteInput(), "example.com");
        click(newOrganizationPO.getCauseInput());
        click(newOrganizationPO.getCategoryInput() + new Random().nextInt(7));
        click(newOrganizationPO.getCategoryInput());
        $(newOrganizationPO.getCategoryInput()).sendKeys(Keys.ENTER);
        $(newOrganizationPO.getCategoryInput()).sendKeys(Keys.TAB);
        writeText(newOrganizationPO.getTargetPopulationInput(), "test");
        click(newOrganizationPO.getInfluencedCountriesInput());
        click(newOrganizationPO.getCountrySelector() + new Random().nextInt(7));
        $(newOrganizationPO.getInfluencedCountriesInput()).sendKeys(Keys.TAB);
        writeText(newOrganizationPO.getYearFoundedInput(), "2019");
        $(newOrganizationPO.getGoToNextPageButton()).click();

    }

    public void uploadOrganisationLogo() {
        waitVisibility(newOrganizationPO.getAddOrganizationLogoButton());
        waitTime(500);
        Actions actions = new Actions(driver);
        actions.moveToElement($(newOrganizationPO.getAddOrganizationLogoButton())).click().build().perform();
        $(newOrganizationPO.getBrowseFilesButton()).sendKeys(config.getOrganizationLogo());
        click(newOrganizationPO.getUploadImageButton());
    }

    public void uploadOrganizationImage() {
        click(newOrganizationPO.getAddOrganizationImagesButton());
        $(newOrganizationPO.getBrowseFilesButton()).sendKeys(config.getOrganizationImage());
        click(newOrganizationPO.getUploadImageButton());

    }

    public void completeSecondPage() {
        writeText(newOrganizationPO.getExecutiveSummaryInput(), "The quick brown fox jumps over the lazy dog");
        writeText(newOrganizationPO.getVisionStatementInput(), "The quick brown fox jumps over the lazy dog");
        writeText(newOrganizationPO.getMissionStatementInput(), "The quick brown fox jumps over the lazy dog");
        writeText(newOrganizationPO.getOrganizationValuesInput(), "The quick brown fox jumps over the lazy dog");
        writeText(newOrganizationPO.getProgramAndActivitiesInput(), "The quick brown fox jumps over the lazy dog");
        $(newOrganizationPO.getGoToNextPageButton()).click();
    }

    public void completeThirdPage() {
        writeText(newOrganizationPO.getOrgLeaderNameInput(), "Fane tester");
        click(newOrganizationPO.getAddOrgLeaderPictureButton());
        $(newOrganizationPO.getBrowseFilesButton()).sendKeys(config.getOrganizationLeaderImage());
        click(newOrganizationPO.getUploadImageButton());
        waitTime(500);
        writeText(newOrganizationPO.getBioInput(), "The quick brown fox jumps over the lazy dog");
        $(newOrganizationPO.getTeamMediaButton()).sendKeys(config.getOrganizationImage());
        click(newOrganizationPO.getUploadImageButton());
        waitTime(500);
        $(newOrganizationPO.getGoToNextPageButton()).click();
    }

    public void completeFinancialYear() {
        waitVisibility(newOrganizationPO.getAddNewFinancialStatementButton());
        waitTime(1000);
        for (int iterator = 0; iterator < 4; iterator++) {
            click(newOrganizationPO.getBudgetYearInput() + iterator);
            waitTime(100);
            $(newOrganizationPO.getBudgetYearInput() + iterator).sendKeys(Keys.ENTER);
            writeText(newOrganizationPO.getFiscalYearEndInput() + iterator, "31 Dec");
            writeText(newOrganizationPO.getRevenueItemNameInput() + iterator + "_0", "test");
            writeText(newOrganizationPO.getRevenueItemBudgetInput() + iterator + "_0", "12");
            writeText(newOrganizationPO.getRevenueItemActualInput() + iterator + "_0", "24");
            writeText(newOrganizationPO.getExpenseItemNameInput() + iterator + "_0", "test");
            writeText(newOrganizationPO.getExpenseItemBudgetInput() + iterator + "_0", "12");
            writeText(newOrganizationPO.getExpenseItemActualInput() + iterator + "_0", "24");
            if (iterator < 3)
                click(newOrganizationPO.getAddNewFinancialStatementButton());
        }
    }

    public void submitOrganbisation() {
        $(newOrganizationPO.getSubmitOpenModalButton()).click();
        click(newOrganizationPO.getSubmitEntityButton());
    }

    public void checkPendingStatus() {
        waitVisibility(makeLiveId);
        Assert.assertEquals($(makeLiveId).getText(), "Pending");
    }

    public void makeLive() {
        click(makeLiveId);
    }

    public void checklLiveStatus() {
        waitTime(1000);
        Assert.assertEquals($(makeLiveId).getText(), "Live");
    }
}
