package Tests;

import Logger.LoggerUtility;
import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class FunctionButtonsTest extends Hooks {

    @Test
    public void testButtons() throws InterruptedException {

        String text = "Anca";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        LoggerUtility.info(" The browser is open ");

        driver.findElement(By.id("name")).sendKeys(text);
        LoggerUtility.info(" User completes with it's name on the 'Enter text' section ");

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        LoggerUtility.info(" User clicks on 'Alert' button ");

        LoggerUtility.info(" User clicks on the 'Ok' button and then the following message appears : ");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        LoggerUtility.info(" User clicks on the confirm button and then the following message appears : ");
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        LoggerUtility.info(" User clicks on the 'Cancel' button");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='mousehover']")).click();
        LoggerUtility.info(" User clicks on the 'Mouse Hover' button");

        driver.findElement(By.xpath("//a[normalize-space()='Top']")).click();
        LoggerUtility.info(" User clicks on 'Top' button");

        driver.findElement(By.id("autocomplete")).sendKeys("Ro");
        LoggerUtility.info(" User clicks on the suggestion button and choose a country");

        Thread.sleep(1500);

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li"));

        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase("Romania"))
            {
                option.click();
                break;
            }
        }
        LoggerUtility.info(" Selected country will be entered in the textbox ");

        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        LoggerUtility.info(" User selects his favorite 'radio' from the checkbox section ");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
        LoggerUtility.info(" User selects his favorite 'option' from the checkbox section ");

        driver.findElement(By.id("opentab")).click();
        LoggerUtility.info(" User clicks on 'Open Tab' button");

        String mainTabHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(mainTabHandle))
            {
                driver.switchTo().window(handle);
                Thread.sleep(1500);
                driver.close();
            }
        }
        driver.switchTo().window(mainTabHandle);
        LoggerUtility.info(" New Tab opens and the user is still on the main page ");
        LoggerUtility.info(" New Tab closes ");


        Thread.sleep(1500);

        driver.findElement(By.id("openwindow")).click();
        LoggerUtility.info(" User clicks on 'Open Window' button ");

        String mainTabHandleAgain = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(mainTabHandleAgain))
            {
                driver.switchTo().window(handle);
                Thread.sleep(1500);
                driver.close();
            }
        }
        driver.switchTo().window(mainTabHandleAgain);
        LoggerUtility.info(" New window opens and the user is still on the main page ");
        LoggerUtility.info(" New Window closes ");

        Thread.sleep(500);

        driver.quit();
        LoggerUtility.info(" The entire page closes ");
    }
}
