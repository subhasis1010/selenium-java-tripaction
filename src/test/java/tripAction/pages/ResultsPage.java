/*
Includes all the results page related objects
Made use of page object model
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
    By roomReserve = By.xpath("//*[@id='hprt-form']/table/tbody/tr[1]/td[6]/div/div/button");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> listHotels() {
        return driver.findElements(listHotels);
    }

    public List<WebElement> avgPrice() {
        return driver.findElements(avgPrice);
    }

    public void roomReserve() {
        driver.findElement(roomReserve).click();
    }


}
