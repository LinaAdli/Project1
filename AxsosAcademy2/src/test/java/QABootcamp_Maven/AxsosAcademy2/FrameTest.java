package QABootcamp_Maven.AxsosAcademy2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest extends TestBaseFrame {

    By framepath = By.xpath("//iframe[@id='frame1']");
    By framepath2 = By.xpath("//iframe[@id='frame2']");
    
    @BeforeMethod
    public void loadPage() {
        driver.get("https://demoqa.com/frames");  
        Reporter.log("Frame page opened successfully.", true);

    }
    
    @Test
    public void isFrameDisplayed() throws InterruptedException {
        WebElement frameElement = driver.findElement(By.id("frame1"));

        if (frameElement.isDisplayed()) {
            Reporter.log("Iframe is present and displayed.", true);
        } else {
            Reporter.log("Iframe is not visible.", true);
            return;
        }

        driver.switchTo().frame(frameElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement iframeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));

        Assert.assertTrue(iframeText.isDisplayed(), "Text inside iframe is not visible.");
        Reporter.log("Successfully found the text inside iframe.", true);
        driver.switchTo().defaultContent();
        
    }

}
