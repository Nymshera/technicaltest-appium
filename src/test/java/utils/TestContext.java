package utils;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class TestContext {
    private AndroidDriver driver;
    private static TestContext instance;

     private TestContext() {
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    
}
