package Tests;

import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Logger;
import Logger.LoggerUtility;
import org.testng.annotations.Test;


public class AddToCartTest extends Hooks {


    @Test
    public void testMethod() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.xpath("//div[12]//div[3]//button[1]")).click();
        LoggerUtility.info(" User add to cart the pumpkin ");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[5]//div[2]//a[2]")).click();
        }
        LoggerUtility.info(" User select the quantity of carrots ");

        driver.findElement(By.xpath("//div[5]//div[3]//button[1]")).click();
        LoggerUtility.info(" User add to cart the quantity of carrots");


        for (int i = 0; i < 1; i++) {
            driver.findElement(By.xpath("//div[19]//div[2]//a[2]")).click();
        }
        LoggerUtility.info(" User select the quantity of musk melon ");

        driver.findElement(By.xpath("//div[19]//div[3]//button[1]")).click();
        LoggerUtility.info(" User add to cart the quantity of musk melon");

        driver.findElement(By.cssSelector("input[placeholder='Search for Vegetables and Fruits']")).sendKeys("Man");
        LoggerUtility.info(" User searches for mango in search bar");

        WebElement quantityInput = driver.findElement(By.xpath("//div[@class='products']//div[@class='product']//input[@class='quantity']"));
        quantityInput.sendKeys(Keys.CONTROL + "a");
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys("6");
        LoggerUtility.info(" User types the quantity of mango ");

        driver.findElement(By.cssSelector("div[class='product-action'] button[type='button']")).click();
        LoggerUtility.info(" User add to cart the quantity of mango");

        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Search for Vegetables and Fruits']"));
        searchInput.sendKeys(Keys.CONTROL + "a");
        searchInput.sendKeys(Keys.DELETE);
        LoggerUtility.info(" User deletes mango in the search bar");
        searchInput.sendKeys("Oni");

        LoggerUtility.info(" User searches for onion in search bar");



    }
}
