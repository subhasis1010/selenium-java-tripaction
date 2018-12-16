/*
Includes all the search page related objects
 */

package tripAction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tripAction.dataprovider.ConfigDataProvider;

public class SearchPage {
    ConfigDataProvider config = new ConfigDataProvider();
    By searchCity = By.xpath("//input[@type='search']");
    By autoComplete = By.xpath("//li[@data-label = 'Los Angeles, California, USA']");
    By startDate = By.xpath("//td[@data-date='" + config.getCheckinDate() + "']");
    By endDate = By.xpath("//td[@data-date='" + config.getCheckoutDate() + "']");
    By searchButton = By.xpath("//span[text()='Search']");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchCity() {
        driver.findElement(searchCity).sendKeys(config.getCityName());
    }

    public void autoComplete() {
        driver.findElement(autoComplete).click();
    }

    public void setStartDate() {
        driver.findElement(startDate).click();
    }

    public void setEndDate() {
        driver.findElement(endDate).click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }


}
