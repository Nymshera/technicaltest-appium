package screens;

import org.openqa.selenium.By;

public class MoreScreen extends BaseScreen {

    public MoreScreen() {
        super(driver);
    }

    public void clickSkillSection() throws Exception {
        clickElement(By.id("com.amazon.dee.app:id/more_skills_and_games"));
    }
    
}
