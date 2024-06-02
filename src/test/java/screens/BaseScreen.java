package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.TestContext;

public class BaseScreen {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    public BaseScreen(WebDriver driver) {
        this.driver = TestContext.getInstance().getDriver();
    }

    public void clickElement(By by) throws Exception {
        try {
            find(by).click();
        } catch (Exception e) {
            throw new Exception("The element " + by + " can't be clicked");
        }
    }

    public boolean elementIsDisplayed(By by) throws Exception {
        try {
            return find(by).isDisplayed();
        } catch (Exception e) {
            throw new Exception("The element isn't displayed");
        }
    }

    public String getText(final By by) throws Exception {
        try {
            return find(by).getText();
        } catch (Exception e) {
            throw new Exception("The text of the " + by + " can't be obtained"); 
        }
    }

    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new Exception("The title can't be obtained");
        }
    }

    private WebElement find(By by) throws Exception {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            throw new Exception("Element isn't found");
        }
    }
        

    public void write(By by, String keysToSend) throws Exception {
        try {
            find(by).clear();
            find(by).sendKeys(keysToSend);
        } catch (Exception e) {
            throw new Exception("The text " + keysToSend + " couldn't be written");
        }
    }

}