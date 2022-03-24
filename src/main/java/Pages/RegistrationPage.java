package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;
    By maleRB = By.id("gender-male");
    By femaleRB = By.id("gender-female");
    By firstNameTB = By.id("FirstName");
    By lastNameTB = By.id("LastName");
    By emailTB = By.id("Email");
    By dayDD = By.name("DateOfBirthDay");
    By monthDD = By.name("DateOfBirthMonth");
    By yearDD = By.name("DateOfBirthYear");
    By companyNameTB = By.id("Company");
    By passwordTB = By.id("Password");
    By confirmPasswordTB = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    public RegistrationPage(WebDriver driver){this.driver = driver;}
    public void setGender(String name){
        if(name.toLowerCase().equals("male"))
            driver.findElement(maleRB).click();
        else
            driver.findElement(femaleRB).click();
    }
    public void setFirstName(String name){driver.findElement(firstNameTB).sendKeys(name);}
    public void setLastName(String name){driver.findElement(lastNameTB).sendKeys(name);}
    public void setEmail(String email){driver.findElement(emailTB).sendKeys(email);}
    private Select selectDropdownElement(By dropdown){return new Select(driver.findElement(dropdown));}
    public void setDay(int day){selectDropdownElement(dayDD).selectByValue(String.valueOf(day));}
    public void setMonth(int month){selectDropdownElement(monthDD).selectByValue(String.valueOf(month));}
    public void setYear(int year){selectDropdownElement(yearDD).selectByValue(String.valueOf(year));}
    public void setCompany(String company){driver.findElement(companyNameTB).sendKeys(company);}
    public void setPassword(String password){driver.findElement(passwordTB).sendKeys(password);}
    public void setConfirmPassword(String confirmPassword){driver.findElement(confirmPasswordTB).sendKeys(confirmPassword);}
    public RegisterCompletePage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new RegisterCompletePage(driver);
    }
}
