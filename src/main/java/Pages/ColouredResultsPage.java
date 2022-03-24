package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ColouredResultsPage extends ResultsPage{
    By availableColours = By.xpath("//*[@class = \"item color-item\"]");
    public ColouredResultsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> availableColoursElementsList(){
        return driver.findElements(availableColours);
    }
    private List<String> availableColoursTitlesList(){return availableColoursElementsList().stream().map(e->e.getText()).collect(Collectors.toList());}
    public void selectColour(String colour){
        int size = availableColoursElementsList().size();
        for (int i = 0;i<size; i++) {
            if(availableColoursTitlesList().get(i).equals(colour)){
                availableColoursElementsList().get(i).click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
                break;
            }
        }
    }
}
