package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public void waitVisibility(String element) {
        if (element.startsWith("//"))  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(element)));

    }
    public void click (String element) {
        waitVisibility(element);
        $(element).click();
    }
    public void writeText (String element, String text) {
        waitVisibility(element);
        $(element).sendKeys(text);
    }
    public String readText (String element) {
        waitVisibility(element);
        return $(element).getText();
    }
    public void assertEquals (String element, String expectedText) {
        Assert.assertEquals(readText(element), expectedText);
    }
    public BaseClass(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public static void waitTime(long fWait) {
        try {
            Thread.sleep(fWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement $(String locator) {
        if (locator.startsWith("//")) return driver.findElement(By.xpath(locator));
        return driver.findElement(By.id(locator));
    }
}
