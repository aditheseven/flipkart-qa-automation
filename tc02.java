
package test_cases;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class tc02 extends TestBase {

    @BeforeMethod
    public void setup() {

        browserSetup();
        geturl("https://www.flipkart.com");

    }

    @Test
    public void productUnavailableTest() throws InterruptedException, IOException {

        // Close login popup
        try {
            driver.findElement(By.xpath("//button[text()='✕']")).click();
        } catch (Exception e) {
            System.out.println("Popup not present");
        }

        // Search Bluetooth Speakers
        driver.findElement(By.name("q")).sendKeys("Bluetooth Speakers", Keys.ENTER);

        Thread.sleep(1000);

        // Click Brand section
        driver.findElement(By.xpath("//div[text()='Brand']")).click();

        Thread.sleep(1000);

        // Select boAt brand
        driver.findElement(By.xpath("//div[contains(text(),'boAt')]")).click();

        Thread.sleep(1000);

        // Rating filter
        driver.findElement(By.xpath("//div[contains(text(),'4★')]")).click();

        Thread.sleep(1000);

        // Sort Price Low to High
        driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')]")).click();

        Thread.sleep(1000);

        // Open first product in new tab
        WebElement firstProduct = driver.findElement(By.xpath("(//a[contains(@href,'/p/')])[1]"));

        String openNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

        firstProduct.sendKeys(openNewTab);

        Thread.sleep(1000);

        // Switch to new tab
        for (String tab : driver.getWindowHandles()) {

            driver.switchTo().window(tab);

        }

        System.out.println("Title: " + driver.getTitle());

        // Scroll to offers section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(2000);

        // Count offers
        List<WebElement> offers = driver.findElements(By.xpath("//div[contains(@aria-label,'Bank offers')]"));

        System.out.println("Number of offers: " + offers.size());

        // Scenario 2 check
        List<WebElement> addToCart = driver.findElements(
                By.xpath("//div[text()='Add to cart']/ancestor::div[contains(@class,'grid-column-2')]"));

        List<WebElement> outOfStock = driver.findElements(
                By.xpath("//*[contains(text(),'Out of Stock')]"));

        if (addToCart.size() == 0 || !addToCart.get(0).isEnabled() || outOfStock.size() > 0) {

            System.out.println("Product unavailable — could not be added to cart.");

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File("result.png");

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved as result.png");
        }

    }

    @AfterMethod
    public void tearDown() {

        teardown();

    }
}

