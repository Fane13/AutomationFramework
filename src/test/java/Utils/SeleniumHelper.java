package Utils;

import StepObject.GroupSO;
import StepObject.LoginSO;
import StepObject.OrganizationSO;
import StepObject.RegisterSO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {
    public WebDriver driver;
    public LoginSO loginSO;
    public RegisterSO registerSO;
    public OrganizationSO organizationSO;
    public GroupSO groupSO;
    public WebDriverWait wait;

    @BeforeTest
    public void openBrowser() throws IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginSO = new LoginSO(driver, wait);
        registerSO = new RegisterSO(driver, wait);
        organizationSO = new OrganizationSO(driver, wait);
        groupSO = new GroupSO(driver,wait);

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @AfterMethod
    public void screenshotAfterEveryFailedTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE)
            takeScreenshot(driver, "C:\\Users\\stefa\\Desktop\\GivingSpace2\\src\\test\\resources" +
                    result.getMethod().getMethodName() +
                    ".png");
    }

    public void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File createdFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(path);
        FileUtils.copyFile(createdFile, destinationFile);
    }
}
