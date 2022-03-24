package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCompletePage {
    WebDriver driver;
    By registrationCompletion = By.className("result");

    public RegisterCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompletionText(){return driver.findElement(registrationCompletion).getText();}
}