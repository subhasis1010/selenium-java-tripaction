/*
Includes all the results page related objects
 */


package tripAction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {

    WebDriver driver;
    By listHotels = By.xpath("//span[@class = 'b-button__text']");
    By avgPrice = By.xpath("//*[@id='hprt-form']/table/tbody/tr/td/div/div[2]/span[starts-with(@class,'hprt-price')]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> listHotels() {
        return driver.findElements(listHotels);
    }

    public List<WebElement> avgPrice() {
        return driver.findElements(avgPrice);
    }


}
