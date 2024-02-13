package Tests;

import Logger.LoggerUtility;
import ShareData.Hooks;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class FunctionButtonsTest extends Hooks {

    @Test
    public void testButtons() throws InterruptedException {

        String text = "Anca";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        LoggerUtility.info("The user clicks on the ok button and then the following message appears: ");
//        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        LoggerUtility.info("The user clicks on the confirm button and then the following message appears: ");
//        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        LoggerUtility.info("The user clicks on the cancel button");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='mousehover']")).click();
        LoggerUtility.info("The user clicks on the Mouse Hover button");

        driver.findElement(By.xpath("//a[normalize-space()='Top']")).click();
        LoggerUtility.info("The user clicks on the Top button");

        driver.findElement(By.xpath("//button[@id='mousehover']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Reload']")).click();

        LoggerUtility.info("The user clicks on the Reload button");

        driver.findElement(By.id("autocomplete")).sendKeys("Ro");
        LoggerUtility.info("The user clicks on the suggestion button and choose a country");

        Thread.sleep(1500);

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li"));

        for (WebElement option : options) {

            if(option.getText().equalsIgnoreCase("Romania"))
            {
                option.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        LoggerUtility.info("The user select the favorite Radio");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
        LoggerUtility.info("The user select the right Option");

        driver.findElement(By.id("opentab")).click();
        LoggerUtility.info("The user clicks on the Open Tab button");

        String mainTabHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(mainTabHandle))
            {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.switchTo().window(mainTabHandle);
        LoggerUtility.info("The tab was opened and the user is still on the main page");

        Thread.sleep(1000);

        driver.findElement(By.id("openwindow")).click();
        LoggerUtility.info("The user clicks on the Open Window button");

        String mainTabHandleAgain = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(mainTabHandleAgain))
            {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.switchTo().window(mainTabHandleAgain);
        LoggerUtility.info("The tab was opened and the user is still on the main page");

    }
}
