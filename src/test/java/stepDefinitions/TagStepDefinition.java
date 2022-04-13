package stepDefinitions;

import Pages.HomePage;
import Pages.ItemPage;
import Pages.ResultsPage;
import Pages.TagResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseStepDefinition;

import java.util.List;

public class TagStepDefinition {
    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;
    TagResultsPage tagResultsPage;
    ItemPage itemPage;
    String requiredTag = "cell";

    @When("User navigates to any category")
    public void navigateToCategory(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        resultsPage = homePage.hoverOverCategory("Apparel").selectSubCategory("Shoes");
    }

    @And("clicks on any tag")
    public void clickOnTag(){
        tagResultsPage = resultsPage.selectTag(requiredTag);
    }

    @Then("The Tag related Items should appear")
    public void testTags(){
        Assert.assertTrue(tagResultsPage.getPageTitle().contains(requiredTag));
        List<String> tagResults = tagResultsPage.getResults();
        for(int i = 0;i<tagResults.size();i++){
            itemPage = tagResultsPage.clickItem(tagResults.get(i));
            Assert.assertTrue(itemPage.checkTagExistence(requiredTag));
            itemPage.returnToResultsPage();
        }
    }
}
