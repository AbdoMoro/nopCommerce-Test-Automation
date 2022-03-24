package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    By registrationLink = By.className("ico-register");
    By loginLink = By.className("ico-login");
    By logoutLink = By.className("ico-logout");
    By searchTB = By.id("small-searchterms");
    By searchButton = By.xpath(".//button[contains(@class,\"search-box-button\")]");
    By currenciesDropbox = By.id("customerCurrency");
    By productPrice = By.className("price");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage clickRegister(){
        driver.findElement(registrationLink).click();
        return new RegistrationPage(driver);
    }

    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public boolean logoutAppeared(){
        return driver.findElement(logoutLink).isDisplayed();
    }

    public void setSearchWord(String searchWord){driver.findElement(searchTB).sendKeys(searchWord);}
    public SearchPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public void selectCurrency(String currency){
        new Select(driver.findElement(currenciesDropbox)).selectByVisibleText(currency);
    }

    public String getProductCurrency(){return driver.findElement(productPrice).getText();}

    public SubCategories hoverOverCategory(String category){
        String categoryPath = String.format(".//a[contains(text(), \"%s\")]", category);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(categoryPath))).perform();
        try {
            return new SubCategories(categoryPath + "/following-sibling::*[@class =\"sublist first-level\"]");
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public class SubCategories{
        String subList;

        public SubCategories(String subList) {
            this.subList = subList;
        }

        public ResultsPage selectSubCategory(String subCategory){
            subList += String.format("//*[contains(@href, \"%s\")]",subCategory.toLowerCase());
            driver.findElement(By.xpath(subList)).click();
            return new ColouredResultsPage(driver);
        }
    }
}
