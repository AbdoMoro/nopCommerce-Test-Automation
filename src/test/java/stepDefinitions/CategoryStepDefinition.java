package stepDefinitions;

import Pages.HomePage;
import Pages.ResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryStepDefinition{
    WebDriver driver;
    HomePage homePage;
    HomePage.SubCategories subCategories;
    ResultsPage resultsPage;

    @When("hover over a category")
    public void hoverOverCategory(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        subCategories = homePage.hoverOverCategory("Apparel");
    }

    @And("select a sub-category")
    public void selectSubCategory(){
        resultsPage = subCategories.selectSubCategory("Shoes");
    }

    @Then("The sub-category page should be displayed")
    public void testCategories(){
        Assert.assertEquals(resultsPage.getPageTitle(),"Shoes");
    }
}
