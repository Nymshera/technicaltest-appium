package screens;

import org.openqa.selenium.By;

public class SimonAuthScreen extends BaseScreen {

    public SimonAuthScreen() {
        super(driver);
    }

    public void inputCredentials() throws Exception {
        write(By.id("username"),"username");
        write(By.id("password"),"password");
        clickElement(By.xpath("//android.widget.Button[@text='Get in']"));
    }

    public void clickAllowButton() throws Exception {
        clickElement(By.xpath("//android.widget.Button[@text='Allow']"));

    }

    public boolean checkLinking() throws Exception {
        return elementIsDisplayed(By.id("com.simon.io:id/success_message"));
    }
    
}
