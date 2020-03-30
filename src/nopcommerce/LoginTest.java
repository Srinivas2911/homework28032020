package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

    @Before
    public void openBrowser() {
        OpeningBrowserChrome("https://demo.nopcommerce.com/");
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        clickOnElement(By.xpath("//a[@class='ico-login']"));
        //Thread.sleep(3000);
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("Expected Message : "+expectedMessage );
        System.out.println("Actual Message : "+actualMessage);
    }

    @Test
    public void verifyUserShouldLoginSucessfully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-login']"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@class='email']"), "Roger123@gmail.com");
        sendTextToElement(By.id("Password"), "Roger1980");
        clickOnElement(By.xpath("//input[@value=\"Log in\"]"));

        String expectedText = "Welcome to our store";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected message : " + expectedText);
        System.out.println("Actual message : " + actualText);

    }

    @Test
    public void verifyUserShouldNotLoginSucessfully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-login']"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@class='email']"), "Roger123@gmail.com");
        sendTextToElement(By.id("Password"), "abcd1980");
        clickOnElement(By.xpath("//input[@value=\"Log in\"]"));

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("Expected Error message : " + expectedErrorMessage);
        System.out.println("Actual Error message : " + actualErrorMessage);

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
