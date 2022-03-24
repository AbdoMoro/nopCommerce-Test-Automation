package stepDefinitions;

import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SearchStepDefinition{
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    String searchWord = "laptop";
    List<String> searchResults;

    @And("logs into the website")
    public void login(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        LoginStepDefinition definition = new LoginStepDefinition();
        definition.navigateToLoginPage();
        definition.enterLoginData();
        definition.clickLoginButton();
    }

    @When("user enters the search word")
    public void SetSearchWord(){homePage.setSearchWord(searchWord);}

    @And("clicks on the search button")
    public void clickSearchButton(){searchPage = homePage.clickSearchButton();}

    @Then("The search results appears")
    public void getSearchResults(){searchResults = searchPage.getSearchResultsTitles();}

    @And("They should be related to the search word")
    public void testSearch(){
        for (String title: searchResults) {
            Assert.assertTrue(title.toLowerCase().contains(searchWord));
        }
    }
}
