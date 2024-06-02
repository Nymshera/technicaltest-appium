package screens;

import org.openqa.selenium.By;

public class SkillScreen extends BaseScreen {

    public SkillScreen() {
        super(driver);
    }

    public void searchSkill() throws Exception {
        write(By.id("search-input"),"Simon io");
        clickElement(By.id("search-input"));
    }

    public void selectSimonSkill() throws Exception {
        clickElement(By.xpath("//android.widget.Button[@content-desc='Simon iO. 'Alexa, apaga el termo eléctrico'.']"));
    }

    public void selectAllowButton() throws Exception {
        clickElement(By.xpath("//android.view.ViewGroup[@content-desc='Permitir su uso']"));
    }

}
