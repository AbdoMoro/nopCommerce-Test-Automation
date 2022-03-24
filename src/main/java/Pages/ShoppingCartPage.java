package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends ProductListPage {
    By termsOfService = By.id("termsofservice");
    By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void approveTermsOfService(){
        driver.findElement(termsOfService).click();
    }

    public CheckoutPage clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
