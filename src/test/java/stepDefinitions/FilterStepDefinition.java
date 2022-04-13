package stepDefinitions;

import Pages.HomePage;
import Pages.ItemPage;
import Pages.ResultsPage;
import Pages.ColouredResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseStepDefinition;

import java.util.List;

public class FilterStepDefinition {
    WebDriver driver;
    HomePage homePage;
    ColouredResultsPage colouredResultsPage;
    ResultsPage resultsPage;
    ItemPage itemPage;
    String colour;

    @When("User opens {string} > {string} category")
    public void selectCategory(String category, String subCategory){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        resultsPage = homePage.hoverOverCategory(category).selectSubCategory(subCategory);
        if(subCategory.equals("Shoes"))
            colouredResultsPage = (ColouredResultsPage) resultsPage;
    }


    @And("Selects {string} Colour")
    public void selectColours(String colour){
        this.colour = colour;
        colouredResultsPage.selectColour(colour);
    }

    @Then("the items displayed should be in the chosen colour")
    public void testColourFilter(){
        List<String> FilteredItems = resultsPage.getResults();
        for(int i = 0;i<FilteredItems.size();i++){
            itemPage = resultsPage.clickItem(FilteredItems.get(i));
            Assert.assertTrue(itemPage.checkColourExistence(colour));
            itemPage.returnToResultsPage();
        }
    }
}
