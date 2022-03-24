package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ProductListPage {
    WebDriver driver;
    By listItems = By.xpath("//tbody//*[contains(@class, \"product\")]//a");

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> listItems(){
        return driver.findElements(listItems).stream().map(e->e.getAttribute("href")).collect(Collectors.toList());
    }

    public boolean itemExists(String itemLink){
        return listItems().contains(itemLink);
    }

    public int listItemCount(){
        return listItems().size();
    }
}
