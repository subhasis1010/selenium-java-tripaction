/*
This is the test case file and the below steps have been executed.
1. Search for Hotels in Los Angeles
2. Select start date as 2019-01-10 and end date as 2019-01-21
3. Find the hotel with minimum price on checkout page
 */

package tripAction.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tripAction.dataprovider.ConfigDataProvider;
import tripAction.pages.ResultsPage;
import tripAction.pages.SearchPage;
import tripAction.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bookings {

    WebDriver driver;
    ConfigDataProvider config = new ConfigDataProvider();
    Utility ul;
    SearchPage searchPage;
    ResultsPage resultsPage;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", config.getChromePath());
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(config.getApplicationURL());
    }

    @Test
    public void searchHotels() {
        ul = new Utility();
        searchPage = new SearchPage(driver);
        resultsPage = new ResultsPage(driver);
        searchPage.searchCity();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.autoComplete();
        searchPage.setStartDate();
        searchPage.setEndDate();
        searchPage.clickSearchButton();

        List<WebElement> listHotels = resultsPage.listHotels();
        listHotels.get(ul.generateRandomNumber()).click();

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        ArrayList<Float> priceList = new ArrayList<Float>();
        List<WebElement> avgPrice = resultsPage.avgPrice();
        for (WebElement a : avgPrice) {
            priceList.add(ul.dataConversion(a.getText()));
        }
        //System.out.println("Price of cheapest available room is " + ul.sortRates(priceList));

        String xpath = null;
        float cheapestRoom = ul.sortRates(priceList);
        int position = 0;
        for (int i = 0; i < avgPrice.size(); i++) {
            if (cheapestRoom == ul.dataConversion(avgPrice.get(i).getText())) {
                position = i + 1;
                break;
            }
        }

        Select selRooms = new Select(driver.findElement(By.xpath(config.calculateXpathSelRooms(position))));
        selRooms.selectByValue("1");

        resultsPage.roomReserve();

    }

    @Test
    public void testAssertion1() {
        Assert.assertTrue(1==1);
    }

    @Test
    public void testAssertion2() {
        Assert.assertTrue(1==2);
    }

    @Test
    public void testAssertion3() {
        Assert.assertTrue(2==2);
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
