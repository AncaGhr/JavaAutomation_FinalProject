package Tests;

import Logger.LoggerUtility;
import ShareData.Hooks;
import org.checkerframework.checker.signature.qual.IdentifierOrPrimitiveType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BookFlightTest extends Hooks {

    @Test
        public void testFlight() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        LoggerUtility.info(" The browser is open ");

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
        LoggerUtility.info(" User selects a country from the list ");

        Thread.sleep(2000);

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
        driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

        LoggerUtility.info(" User selects his favorite option ");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        LoggerUtility.info(" User selects number of adults ");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        LoggerUtility.info(" User selects departure location : ");
        System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        LoggerUtility.info(" User selects arrival location : ");
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).getText());


       //Buton 1
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
        String aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
        String aYear = driver.findElement(By.className("ui-datepicker-year")).getText();

        while(!aMonth.equals("March") && aYear.equals("2024")){

            driver.findElement(By.xpath("//a[@data-handler='next']")).click();
            aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            aYear = driver.findElement(By.className("ui-datepicker-year")).getText();
        }
        driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='23']")).click();

        LoggerUtility.info(" User selects departure date : " );
        System.out.println(driver.findElement(By.xpath("//span[@id='view_fulldate_id_1']")).getText());

//        //Buton 2

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
        WebDriverWait waitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
        String a2Month = driver.findElement(By.className("ui-datepicker-month")).getText();
        String a2Year = driver.findElement(By.className("ui-datepicker-year")).getText();

        while(!a2Month.equals("July") && a2Year.equals("2024")){

            driver.findElement(By.xpath("//a[@data-handler='next']")).click();
            a2Month = driver.findElement(By.className("ui-datepicker-month")).getText();
            a2Year = driver.findElement(By.className("ui-datepicker-year")).getText();
        }
        driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='31']")).click();

        LoggerUtility.info(" User selects arrival date : ");
        System.out.println(driver.findElement(By.xpath("//span[@id='view_fulldate_id_2']")).getText());

        LoggerUtility.info(" User selects currency method : ");
        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']//option[@value='USD']")).click();
        System.out.println(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']//option[@value='USD']")).getText());

        Thread.sleep(500);

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
        searchButton.click();

        LoggerUtility.info(" User starts to search a flight ");


    }
}

