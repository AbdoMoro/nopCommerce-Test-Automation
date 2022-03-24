package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    By country = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By continue1 = By.xpath("//*[@name = \"save\"][@class=\"button-1 new-address-next-step-button\"]");
    By continue2 = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    By continue3 = By.xpath("//*[@id=\"payment-method-please-wait\"]/preceding-sibling::button");
    By continue4 = By.xpath("//*[@id=\"checkout-step-payment-info\"]//button");
    By confirm = By.xpath("//*[contains(@class,\"confirm-order-next-step-button\")]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCountry(String country){new Select(driver.findElement(this.country)).selectByVisibleText(country);}
    public void setCity(String city){driver.findElement(this.city).sendKeys(city);}
    public void setAddress1(String address){driver.findElement(this.address1).sendKeys(address);}
    public void setZipCode(String zipCode){driver.findElement(this.zipCode).sendKeys(zipCode);}
    public void setPhoneNumber(String phoneNumber){driver.findElement(this.phoneNumber).sendKeys(phoneNumber);}
    public void clickContinue1(){waitTillItemLoads(driver.findElement(continue1)); driver.findElement(continue1).click();}
    public void clickContinue2(){waitTillItemLoads(driver.findElement(continue2)); driver.findElement(continue2).click();}
    public void clickContinue3(){waitTillItemLoads(driver.findElement(continue3)); driver.findElement(continue3).click();}
    public void clickContinue4(){waitTillItemLoads(driver.findElement(continue4)); driver.findElement(continue4).click();}
    public CheckoutCompletedPage clickConfirm(){
        waitTillItemLoads(driver.findElement(confirm));
        driver.findElement(confirm).click();
        return new CheckoutCompletedPage(driver);
    }
    private void waitTillItemLoads(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
