package stepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinition {
    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;
    ItemPage itemPage;
    ShoppingCartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutCompletedPage checkoutCompletedPage;

    @And("adds products to the shopping cart")
    public void addItemToCart(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        resultsPage = homePage.hoverOverCategory("Electronics").selectSubCategory("Cell-phones");
        itemPage = resultsPage.clickItem(resultsPage.getResults().get(1));
        itemPage.clickAddToCartButton();
        cartPage = (ShoppingCartPage) itemPage.clickMessageLink("shopping cart");
    }

    @When("hits checkout and completes the required data")
    public void hits_checkout_and_completes_the_required_data(){
        cartPage.approveTermsOfService();
        checkoutPage = cartPage.clickCheckoutButton();
        try {
            checkoutPage.setCountry("Egypt");
            checkoutPage.setCity("Cairo");
            checkoutPage.setAddress1("Cairo");
            checkoutPage.setZipCode("11111");
            checkoutPage.setPhoneNumber("01111111111");
        }catch(Exception e){}
        finally {
            checkoutPage.clickContinue1();
            checkoutPage.clickContinue2();
            checkoutPage.clickContinue3();
            checkoutPage.clickContinue4();
            checkoutCompletedPage = checkoutPage.clickConfirm();
        }
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        Assert.assertEquals(checkoutCompletedPage.getConfirmationMessage(),"Your order has been successfully processed!");
    }
}
