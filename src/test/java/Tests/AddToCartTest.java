package Tests;

import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Logger;
import Logger.LoggerUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class AddToCartTest extends Hooks {


    @Test
    public void testMethod() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.xpath("//div[12]//div[3]//button[1]")).click();
        LoggerUtility.info(" User adds to cart the pumpkin ");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[5]//div[2]//a[2]")).click();
        }
        LoggerUtility.info(" User selects the quantity of carrots ");

        driver.findElement(By.xpath("//div[5]//div[3]//button[1]")).click();
        LoggerUtility.info(" Carrots were added in the cart by the user ");


        for (int i = 0; i < 1; i++) {
            driver.findElement(By.xpath("//div[19]//div[2]//a[2]")).click();
        }
        LoggerUtility.info(" User selects the quantity of musk melon ");

        driver.findElement(By.xpath("//div[19]//div[3]//button[1]")).click();
        LoggerUtility.info(" Musk melon was added to cart ");

        driver.findElement(By.cssSelector("input[placeholder='Search for Vegetables and Fruits']")).sendKeys("Man");
        LoggerUtility.info(" User searches for mango in the search bar ");


        WebElement quantityInput = driver.findElement(By.xpath("//div[@class='products']//div[@class='product']//input[@class='quantity']"));
        quantityInput.sendKeys(Keys.CONTROL + "a");
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys("6");
        LoggerUtility.info(" User chooses the quantity of mango ");


        WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='product']//div[@class='product-action']//button[normalize-space()='ADD TO CART']"));
        for (int i = 0; i < 6; i++) {
            addToCartButton.click();
            Thread.sleep(500);
        }
        LoggerUtility.info(" Mangoes were added to cart ");

        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Search for Vegetables and Fruits']"));
        searchInput.sendKeys(Keys.CONTROL + "a");
        searchInput.sendKeys(Keys.DELETE);
        LoggerUtility.info(" User deletes mango from the search bar");


        searchInput.sendKeys("Al");
        LoggerUtility.info(" User searches for almonds in search bar");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.products")));

        WebElement currentQuantityInput = driver.findElement(By.xpath("//div[2]//div[2]//input[1]"));
        String currentQuantityStr = currentQuantityInput.getAttribute("value");

        int currentQuantity = Integer.parseInt(currentQuantityStr);

        if (currentQuantity >= 1) {
            currentQuantityInput.sendKeys(Keys.CONTROL + "a");
            currentQuantityInput.sendKeys(Keys.DELETE);
            LoggerUtility.info(" User deletes current quantity value");

            for (int i = 0; i < 7; i++) {
                WebElement almondsIncrementButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Almonds')]//parent::div[@class='product']//a[@class='increment']")));
                almondsIncrementButton.click();
            }
        }
        LoggerUtility.info(" User clicks on the increment button for Almonds");

        WebElement almondsAddToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Almonds')]//parent::div[@class='product']//button[contains(text(),'ADD TO CART')]")));
        almondsAddToCartButton.click();
        LoggerUtility.info(" User adds Almonds to cart");

        WebElement cartInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart-icon']")));
        cartInfo.click();
        LoggerUtility.info(" User clicks on the 'cart' button ");

        WebElement proceedToCheckout = driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"));
        proceedToCheckout.click();
        LoggerUtility.info(" User clicks to 'proceed to checkout' button ");

        WebDriverWait waitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalAmountElement = waitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='totAmt']")));
        String totalAmountText = totalAmountElement.getText();

        WebElement discountElement = waitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='discountPerc']")));
        String discountText = discountElement.getText();

        WebElement totalAfterDiscountElement = waitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='discountAmt']")));
        String totalAfterDiscountText = totalAfterDiscountElement.getText();

        System.out.println("Total Amount: " + totalAmountText);
        System.out.println("Discount: " + discountText);
        System.out.println("Total After Discount: " + totalAfterDiscountText);

        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
        LoggerUtility.info(" User clicks on 'place order' button ");

        WebElement dropdown = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
        Select select = new Select(dropdown);
        Thread.sleep(100);
        select.selectByVisibleText("Romania");
        LoggerUtility.info(" User clicks on 'dropwdown' button and select the country he wants ");

        Thread.sleep(100);

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        LoggerUtility.info(" User agrees with 'Terms&Conditions' and mark the checkbox ");

        Thread.sleep(100);

        driver.findElement(By.xpath("//div[@class='wrapperTwo']//button[text()='Proceed']")).click();
        LoggerUtility.info(" User clicks on the 'Proceed' button ");

        WebDriverWait waitWaitProceed = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement proceedTextElement = waitWaitProceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]")));
        String proceedText = proceedTextElement.getText();

        System.out.println("Order confirmation : " + proceedText);

        Thread.sleep(500);

        driver.quit();

    }
}
