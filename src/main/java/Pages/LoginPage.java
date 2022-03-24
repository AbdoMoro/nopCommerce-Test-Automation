package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By emailTB = By.id("Email");
    By passwordTB = By.id("Password");
    By loginButton = By.xpath(".//button[contains(text(), \"Log in\")]");
    By forgotPasswordLink = By.linkText("Forgot password?");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email){driver.findElement(emailTB).sendKeys(email);}
    public void setPassword(String password){driver.findElement(passwordTB).sendKeys(password);}
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public PasswordRecoveryPage clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return new PasswordRecoveryPage(driver);
    }
}
