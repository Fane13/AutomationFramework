package StepObject;

import PageObject.GroupPO;
import PageObject.HomePO;
import PageObject.LoginPO;
import Utils.BaseClass;
import Utils.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Random;

public class GroupSO extends BaseClass {
    LoginPO loginPo = new LoginPO();
    HomePO homePO = new HomePO();
    GroupPO groupPO = new GroupPO();
    Configuration config = new Configuration();
    public final String groupName = generateRandomGroupName();
    public GroupSO(WebDriver driver, WebDriverWait wait) throws IOException, ParseException {
        super(driver, wait);
    }
    public String generateRandomGroupName() {
        return "GroupTest" + new Random().nextInt(99999);

    }
    public void goToMyGroups(){
        click(homePO.getGroupsButton());
    }
    public void clickOnCreateGroup(){
        click(groupPO.getCreateGroupButton());
    }

    public void completeGroupForm(){
        writeText(groupPO.getGroupName(),groupName);
        writeText(groupPO.getGroupDescription(),"The quick brown fox jumps over the lazy dog");
        $(groupPO.getGroupMediaVideoUpload()).sendKeys(config.getGroupImage());
        click(groupPO.getUploadImageButton());
        waitTime(3000);
    }

    public void submitEntity(){
        click(groupPO.getSubmit());
        click(groupPO.getSubmitEntity());
        waitTime(3000);
    }

}
