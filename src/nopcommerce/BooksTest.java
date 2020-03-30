package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class BooksTest extends Utility {

    @Before
    public void openBrowser() {
        OpeningBrowserChrome("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyUserShouldNavigateToBooksPage() throws InterruptedException {

        clickOnElement(By.linkText("Books"));

        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("//div[@class=\"page-title\"]//h1"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Result : "+ expectedText);
        System.out.println("Actual Result : "+ actualText);
    }

    @Test
    public void booksPage() {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        sortingAtoZ(By.tagName("h2"));
    }

    @Test
    public void productAddedToWishList() throws InterruptedException {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//select[@name='products-orderby']"));
        clickOnElement(By.xpath(" //div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));        String expectedText = "The product has been added to your wishlist";
        Thread.sleep(3000);
        String actualText = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Text : " +expectedText);
        System.out.println("Actual Text : " +actualText);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
