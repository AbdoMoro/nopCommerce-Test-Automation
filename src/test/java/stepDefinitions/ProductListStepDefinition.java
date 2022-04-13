package stepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseStepDefinition;

public class ProductListStepDefinition {
    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;
    ItemPage itemPage;
    ProductListPage productListPage;

    @When("User navigates to any product")
    public void openItem(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        resultsPage = homePage.hoverOverCategory("Electronics").selectSubCategory("Cell-phones");
        itemPage = resultsPage.clickItem(resultsPage.getResults().get(0));
    }

    @And("clicks on the Add to {string} button")
    public void clickAddToCart(String listType){
        if(listType.equals("shopping cart"))
            itemPage.clickAddToCartButton();
        else if(listType.equals("wishlist"))
            itemPage.clickAddToWishlistButton();
        else if(listType.equals("Compare list"))
            itemPage.clickAddToCompareListButton();
    }

    @Then("a confirmation message should be displayed and the item added to the {string}")
    public void testProductList(String listType){

        Assert.assertEquals(itemPage.getConfirmationText(), String.format("The product has been added to your %s", listType));
        String itemLink = itemPage.getItemLink();
        productListPage = itemPage.clickMessageLink(listType);
        Assert.assertTrue(productListPage.listItemCount()>0);
        Assert.assertTrue(productListPage.itemExists(itemLink));
    }
}
