package Tests;
import Logger.LoggerUtility;
import ShareData.Hooks;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest extends Hooks {

    @Test
    public void testFrame() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1450)");

        driver.switchTo().frame("courses-iframe");

        WebElement registerButton = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerButton.click();

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();

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

    }
}