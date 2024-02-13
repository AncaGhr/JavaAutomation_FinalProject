package FlightBookingTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountryTypeButton {

    @Test
        public void countryType() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            driver.findElement(By.id("autosuggest")).sendKeys("ind");
            Thread.sleep(1500);
            List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

            for (WebElement option : options) {

                if(option.getText().equalsIgnoreCase("India"))
                {
                    option.click();
                    break;
                }
            }
        }
    }

