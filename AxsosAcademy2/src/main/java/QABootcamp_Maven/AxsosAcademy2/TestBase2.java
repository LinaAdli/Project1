package QABootcamp_Maven.AxsosAcademy2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Reporter;

public class TestBase2 {
    protected WebDriver driver;
    private static String baseUrl = "https://demoqa.com/text-box";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        Reporter.log("Opening the URL: " + baseUrl, true); 
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        Reporter.log("Browser closed successfully.", true); 
    }
}

