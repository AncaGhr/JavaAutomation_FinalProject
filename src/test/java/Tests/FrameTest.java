package Tests;
import Logger.LoggerUtility;
import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest extends Hooks {

    @Test
    public void testFrame() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        LoggerUtility.info(" The browser is open ");


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1450)");
        LoggerUtility.info(" User makes a scroll ");

        driver.switchTo().frame("courses-iframe");
        LoggerUtility.info(" User selects frame ");

        WebElement registerButton = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerButton.click();
        LoggerUtility.info(" User clicks in the frame on 'Register' button ");
        Thread.sleep(500);

        driver.switchTo().defaultContent();
        LoggerUtility.info(" User moves  attentions to the frame ");

        WebDriverWait waitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement openWindow= waitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='openwindow']")));
        openWindow.click();
        LoggerUtility.info(" New Window opens ");

        String tabHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(tabHandle))
            {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(tabHandle);
        LoggerUtility.info(" New Window opens and the user has the focus on the second page");
        LoggerUtility.info(" New Window closes ");

        Thread.sleep(500);

        driver.quit();
        LoggerUtility.info(" The entire page closes ");

    }
}