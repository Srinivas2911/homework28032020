package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class ElectronicsTest extends Utility {

    @Before
    public void openBrowser() {
        OpeningBrowserChrome("https://demo.nopcommerce.com/");

    }

    @Test
    public void mouseOverElectronics() throws InterruptedException {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        Thread.sleep(3000);

        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Expected Result : "+ expectedResult);
        System.out.println("Actual Result : "+ actualResult);
    }

    @Test
    public void assertPositionLowToHigh() {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        selectByVisibleText(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        sortbyPrices(By.className("prices"));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
