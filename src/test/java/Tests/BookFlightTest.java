package Tests;

import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookFlightTest extends Hooks {

    @Test
        public void testFlight() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        Thread.sleep(1500);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {

            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        Thread.sleep(2000);

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
        driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
//            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());

        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).getText());

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']//option[@value='USD']")).click();

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("it's enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }
}

