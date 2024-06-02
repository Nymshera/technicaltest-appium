package screens;

import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen{

    public HomeScreen() {
        super(driver);
    }

    public void clickMoreButton() throws Exception {
        clickElement(By.id("com.amazon.dee.app:id/tab_more_icon"));
    }
    
}
