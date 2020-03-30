package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class ComputersTest extends Utility {

    @Before
    public void openBrowser() {
        OpeningBrowserChrome("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyUserCanNavigateToComputersPage() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));

        String expectedResult = "Computers";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Expected Result : " + expectedResult);
        System.out.println("Actual Result : " + actualResult);
    }

    @Test
    public void verifyMessageProductAddedtoCart() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        clickOnElement(By.xpath("//h1[contains(text(),'Computers')]"));
        clickOnElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));

        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[1]//a[1]//img[1]"));
        //clickOnElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-1']"));

        Thread.sleep(3000);
        String expectedResult = "The product has been added to your shopping cart";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(getTextFromElement(By.xpath("//p[@class='content']")));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}