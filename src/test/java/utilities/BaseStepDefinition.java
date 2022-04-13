package utilities;

import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStepDefinition {

    public static WebDriver driver;
    public static HomePage homePage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }


    @After
    public void closeDriver(){
        driver.quit();
    }

}
