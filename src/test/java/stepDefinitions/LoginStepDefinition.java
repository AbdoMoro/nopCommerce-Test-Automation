package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PasswordRecoveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseStepDefinition;

public class LoginStepDefinition{
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    PasswordRecoveryPage recoveryPage;

    @And("clicks on the login Link")
    public void navigateToLoginPage(){
        driver = BaseStepDefinition.driver;
        homePage = BaseStepDefinition.homePage;
        loginPage = homePage.clickLogin();
    }

    @When("User enters valid email and password")
    public void enterLoginData(){
        loginPage.setEmail("abdo@gmail.com");
        loginPage.setPassword("12345678");
    }

    @And("clicks login button")
    public void clickLoginButton(){
        homePage = loginPage.clickLoginButton();
    }

    @Then("User should login successfully")
    public void testLoggingIn(){
        Assert.assertTrue(homePage.logoutAppeared());
    }

    @And("User clicks on forgotPassword link")
    public void navigateToRecoveryPage(){
        recoveryPage = loginPage.clickForgotPasswordLink();
    }

    @When("User enters his-her email")
    public void setEmail(){
        recoveryPage.setEmail("abdo@gmail.com");
    }

    @And("clicks recover button")
    public void clickRecoverButton(){
        recoveryPage.clickRecoverButton();
    }

    @Then("A recovery confirmation message should be displayed")
    public void testForgotPassword(){
        Assert.assertEquals(recoveryPage.getConfirmationText(),"Email with instructions has been sent to you.");
    }
}
