package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
    WebDriver driver;
    String colourTitle, tagTitle;
    By addToCartButton = By.xpath("//button[contains(@id,\"add-to-cart-button\")]");
    By addToWishlistButton = By.xpath("//button[contains(@id,\"add-to-wishlist-button\")]");
    By addToCompareListButton = By.xpath("//button[contains(@class,\"add-to-compare-list-button\")] ");
    By confirmationText = By.xpath("//*[@class=\"bar-notification success\"]");
    By listLink = By.xpath("//*[@class=\"bar-notification success\"]//a");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkColourExistence(String colour){
        colourTitle = String.format("//*[@id = \"color-squares-10\"]//*[@title = \"%s\"]", colour);
        return driver.findElement(By.xpath(colourTitle)).isDisplayed();

    }

    public boolean checkTagExistence(String tag){
        tagTitle = String.format("//*[@class=\"product-tags-list\"]//a[contains(@href,\"%s\")]", tag);
        return driver.findElement(By.xpath(tagTitle)).isDisplayed();
    }

    public String getItemLink(){
        return driver.getCurrentUrl();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public String getConfirmationText(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationText));
        return driver.findElement(confirmationText).getText();
    }

    public ProductListPage clickMessageLink(String listType){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(listLink));
        driver.findElement(listLink).click();
        if(listType.equals("shopping cart"))
            return new ShoppingCartPage(driver);
        else if(listType.equals("wishlist"))
            return new WishlistPage(driver);
        else if(listType.equals("product comparison"))
            return new ProductComparisonPage(driver);
        return null;
    }

    public void clickAddToWishlistButton(){
        driver.findElement(addToWishlistButton).click();
    }

    public void clickAddToCompareListButton(){
        driver.findElement(addToCompareListButton).click();
    }

    public ResultsPage returnToResultsPage(){
        driver.navigate().back();
        return new ResultsPage(driver);
    }
}
