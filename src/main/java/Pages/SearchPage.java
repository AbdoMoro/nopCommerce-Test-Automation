package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends ResultsPage{

    By searchResults = By.className("product-title");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSearchResultsTitles(){
        List<WebElement> searchResultsElements = driver.findElements(searchResults);
        return searchResultsElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

}
