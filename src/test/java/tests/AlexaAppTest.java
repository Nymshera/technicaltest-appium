package tests;
import io.appium.java_client.android.AndroidDriver;
import screens.HomeScreen;
import screens.MoreScreen;
import screens.SimonAuthScreen;
import screens.SkillScreen;
import utils.TestContext;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AlexaAppTest {
    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel 3 API 31");
        caps.setCapability("appium:appPackage", "com.amazon.dee.app");
        caps.setCapability("appium:appActivity", "com.amazon.dee.app.Launcher");
        caps.setCapability("appium:automationName", "UiAutomator2");
        //caps.setCapability("appium:app", "/Users/jess/Downloads/amazon-alexa-2-2-567992-0.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        TestContext.getInstance().setDriver(driver);
    }

    @Test
    public void testLinkSimonIOSkill() throws Exception {
        HomeScreen homeScreen = new HomeScreen();
        MoreScreen moreScreen = new MoreScreen();
        SkillScreen skillScreen = new SkillScreen();
        SimonAuthScreen simonAuthScreen = new SimonAuthScreen();

        // Navegar a la pantalla More
        homeScreen.clickMoreButton();

        //Navegar a la seccion de las skills
        moreScreen.clickSkillSection();

        // Buscar la skill "Simon iO"
        skillScreen.searchSkill();

        //Seleccionamos la skill
        skillScreen.selectSimonSkill();

        //Seleccionamos boton para vincular
        skillScreen.selectAllowButton();

        // Ingresar credenciales del usuario registrado en la app de Simon iO
        simonAuthScreen.inputCredentials();

        //Vinculamos cuenta
        simonAuthScreen.clickAllowButton();

        // Verificar la vinculación
        Assertions.assertTrue(simonAuthScreen.checkLinking());


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
