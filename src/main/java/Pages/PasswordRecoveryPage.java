package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    WebDriver driver;
    By emailTB = By.id("Email");
    By recoverButton = By.name("send-email");
    By confirmationText = By.xpath(".//*[@class=\"content\"]");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email){driver.findElement(emailTB).sendKeys(email);}
    public void clickRecoverButton(){driver.findElement(recoverButton).click();}
    public String getConfirmationText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmationText)));
        return driver.findElement(confirmationText).getText();
    }
}
