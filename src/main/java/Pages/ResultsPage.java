package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage {
    WebDriver driver;
    By pageTitle = By.className("page-title");
    By results = By.xpath("//*[@class=\"details\"]//a");
    By tag;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(){return driver.findElement(pageTitle).getText();}

    public List<String> getResults(){
        return driver.findElements(results).stream().map(e->e.getAttribute("href")).collect(Collectors.toList());
    }

    public ItemPage clickItem(String link){
        link = "/"+link.split("/")[3];
        String item = String.format("//*[@class=\"details\"]//a[@href=\"%s\"]",link);
        WebElement element = driver.findElement(By.xpath(item));
        element.click();
        return new ItemPage(driver);
    }

    public TagResultsPage selectTag(String tagTitle){
        tag = By.linkText(tagTitle);
        driver.findElement(tag).click();
        return new TagResultsPage(driver);
    }

}
