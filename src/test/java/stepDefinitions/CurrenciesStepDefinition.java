package stepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseStepDefinition;

public class CurrenciesStepDefinition{
    WebDriver driver;
    HomePage homePage;

    @When("User clicks on the currencies dropbox and chooses Euro")
    public void chooseEuro(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        homePage.selectCurrency("Euro");
    }

    @Then("The product prices should be in Euro")
    public void testCurrencies(){
        Assert.assertTrue(homePage.getProductCurrency().contains("€"));
    }

}
