package stepDefinitions;

import Pages.HomePage;
import Pages.RegisterCompletePage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationStepDefinition{
    WebDriver driver;
    HomePage homePage;
    RegistrationPage registrationPage;
    RegisterCompletePage registerCompletePage;

    @Given("User open the Website homepage")
    public void navigateToHomePage(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
    }

    @And("clicks on the register Link")
    public void navigateToRegistrationPage(){
        registrationPage = homePage.clickRegister();
    }

    @When("User enters valid data")
    public void enterRegistrationData(){
        registrationPage.setGender("male");
        registrationPage.setFirstName("Abdelrahman");
        registrationPage.setLastName("Amr");
        registrationPage.setDay(4);
        registrationPage.setMonth(10);
        registrationPage.setYear(2000);
        registrationPage.setEmail("abdo@gmail.com");
        registrationPage.setCompany("freelance");
        registrationPage.setPassword("12345678");
        registrationPage.setConfirmPassword("12345678");
    }

    @And("clicks on the register button")
    public void clickRegisterButton(){
        registerCompletePage = registrationPage.clickRegisterButton();
    }

    @Then("A registration confirmation message should be displayed")
    public void testRegistration(){
        Assert.assertEquals(registerCompletePage.getCompletionText(),"Your registration completed");
    }
}
