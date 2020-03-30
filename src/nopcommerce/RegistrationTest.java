package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;

public class RegistrationTest extends Utility {

    @Before
    public void openBrowser() {
        OpeningBrowserChrome("https://demo.nopcommerce.com/");
    }

    @Test
    public void userShouldNavigateToRegisterPage() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));
        Thread.sleep(3000);

        clickOnElement(By.xpath("//span[@class=\"male\"]//input[@type='radio']"));

        sendTextToElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"FirstName\"]"), "Roger");

        sendTextToElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"LastName\"]"), "Moore");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "1");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "January");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1980");

        clickOnElement(By.xpath("//input[@id='Email']"));

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "Roger" + randomInt + "@gmail.com");

        sendTextToElement(By.xpath("//input[@id='Company']"), "Roger International Ltd.");

        sendTextToElement(By.xpath("//div[@class=\"inputs\"]//input[@type=\"checkbox\"]"), "");

        sendTextToElement(By.xpath("//input[@id='Password']"), "Roger1980");

        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Roger1980");

        clickOnElement(By.xpath("//input[@id='register-button']"));

        getTextFromElement(By.xpath("//div[@class=\"result\"]"));

        String expectedMessage = "Your registration completed";
        String actualMessage = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("Expected message : " + expectedMessage);
        System.out.println("Actual message : " + actualMessage);

    }

    @Test
    public void userShouldNotRegister() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));
        Thread.sleep(3000);

        clickOnElement(By.xpath("//span[@class=\"male\"]//input[@type='radio']"));

        sendTextToElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"FirstName\"]"), "Roger");

        sendTextToElement(By.xpath("//div [@class=\"inputs\"]//input[@name=\"LastName\"]"), "Moore");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "1");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "January");

        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1980");

        clickOnElement(By.xpath("//input[@id='Email']"));

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "Roger" + randomInt + "@gmail.com");

        sendTextToElement(By.xpath("//input[@id='Company']"), "Roger International Ltd.");

        sendTextToElement(By.xpath("//div[@class=\"inputs\"]//input[@type=\"checkbox\"]"), "");

        sendTextToElement(By.xpath("//input[@id='Password']"), "Roger1980");

        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Roger1999999999999");

        clickOnElement(By.xpath("//input[@id='register-button']"));

        //getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Thread.sleep(3000);
        String expectedMessage = "The password and confirmation password do not match.";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'The password and confirmation password do not matc')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("Expected message : " + expectedMessage);
        System.out.println("Actual message : " + actualMessage);

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
