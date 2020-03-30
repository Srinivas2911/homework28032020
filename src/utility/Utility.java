package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Utility {

    public WebDriver driver;

    public void OpeningBrowserChrome (String baseUrl){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectByIndex (By by, int index){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByValue (By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByVisibleText (By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void mouseHoverToElement (By by){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElementAndClick (By by){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).click().perform();
    }

    public void sortingAtoZ (By by){
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement links : elementList) {
            obtainedList.add(links.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(obtainedList);
        Collections.sort(sortedList);
        Assert.assertEquals(sortedList, obtainedList);
        System.out.println("Obtained Product List :" + obtainedList);
        System.out.println("Sorted Product list :" + sortedList);
    }

public void sortbyPrices (By by) {
    List<WebElement> elements = driver.findElements(By.className("prices"));
    List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(toList());
    List<String> mySortedPrices = new ArrayList<>();
    for (WebElement element : elements) {
        String text = element.getText();
        mySortedPrices.add(text);
    }
    //mySortedPrices.sort(Comparator.comparingInt(s -> Integer.valueOf(s)));
    Assert.assertEquals(webSortedPrices, mySortedPrices);
    System.out.println("Expected Result : "+ mySortedPrices);
    System.out.println("Actual Result : "+ webSortedPrices);
}

}
