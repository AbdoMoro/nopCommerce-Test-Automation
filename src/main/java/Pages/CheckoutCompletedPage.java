package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletedPage {
    WebDriver driver;
    By confirmationMessage = By.xpath("//*[@class=\"section order-completed\"]/*[@class =\"title\"]");

    public CheckoutCompletedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage));
        return driver.findElement(confirmationMessage).getText();
    }


}
