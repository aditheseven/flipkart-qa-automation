package base;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void browserSetup() {
        ChromeOptions c = new ChromeOptions();
        c.addArguments("--guest");
        c.addArguments("--disable-notifications");
        c.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(c);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void geturl(String url) {
        driver.get(url);
    }

    public static void ts(String Ss) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File cap = ts.getScreenshotAs(OutputType.FILE);
            File src = new File("C:\\flipkart-automation-framework\\Screenshots\\" + Ss + ".png");
            src.getParentFile().mkdirs(); // Create directory if not exists
            FileHandler.copy(cap, src);
            System.out.println("Screenshot saved: " + src.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
