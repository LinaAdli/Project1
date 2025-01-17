package QABootcamp_Maven.AxsosAcademy2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TextBox {

    private WebDriver driver;
    private By textBoxPage = By.xpath("//span[contains(@class, 'text') and contains(text(), 'Text Box')]");
    private By fullNameField = By.id("userName");
    private By useremailField = By.id("userEmail");
    private By currentAdressField = By.id("currentAddress");
    private By permenentAdressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By iframeForSubmit = By.xpath("//*[@id=\"google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0\"]");

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public void OpentextBoxPage() {
        Reporter.log("Opening TextBox page.", true);  
        driver.findElement(textBoxPage).click();
        Reporter.log("TextBox page opened successfully.", true);  
    }

    public void enterfullNanme(String userName) {
        Reporter.log("Entering Full Name: " + userName, true);  
        driver.findElement(fullNameField).sendKeys(userName);
    }

    public void entercuserEmail(String userEmail) {
        Reporter.log("Entering User Email: " + userEmail, true); 
        driver.findElement(useremailField).sendKeys(userEmail);
    }

    public void enterCurrentAddress(String currentAdress) {
        Reporter.log("Entering Current Address: " + currentAdress, true);  
        driver.findElement(currentAdressField).sendKeys(currentAdress);
    }

    public void enterPermenentAddress(String PermenentAdress) {
        Reporter.log("Entering Permanent Address: " + PermenentAdress, true);  
        driver.findElement(permenentAdressField).sendKeys(PermenentAdress);
    }

    public void submitTextBoxButton() throws InterruptedException {
        Reporter.log("Waiting for Submit button to be clickable.", true); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        Reporter.log("Clicking on Submit button.", true); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        Thread.sleep(5000);
        Reporter.log("Submit button clicked.", true); 
    }

    public void clearuserName() {
        WebElement usernameField = driver.findElement(fullNameField);
        if (usernameField != null && !usernameField.getAttribute("value").isEmpty()) {
            Reporter.log("Clearing Full Name field.", true); 
            usernameField.clear();
        }
    }

    public void clearuserEmail() {
        WebElement useremail = driver.findElement(useremailField);
        if (useremail != null && !useremail.getAttribute("value").isEmpty()) {
            Reporter.log("Clearing User Email field.", true);  
            useremail.clear();
        }
    }

    public void clearcurrentAdress() {
        WebElement currentAdress = driver.findElement(currentAdressField);
        if (currentAdress != null && !currentAdress.getAttribute("value").isEmpty()) {
            Reporter.log("Clearing Current Address field.", true);  
            currentAdress.clear();
        }
    }

    public void clearpermenentAdress() {
        WebElement permenentAdress = driver.findElement(permenentAdressField);
        if (permenentAdress != null && !permenentAdress.getAttribute("value").isEmpty()) {
            Reporter.log("Clearing Permanent Address field.", true); 
            permenentAdress.clear();
        }
    }

    public void AddNewTextBox(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        Reporter.log("Filling the TextBox form.", true);  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        OpentextBoxPage();
        clearuserName();
        enterfullNanme(userName);

        clearuserEmail();
        entercuserEmail(userEmail);

        clearcurrentAdress();
        enterCurrentAddress(currentAdress);

        clearpermenentAdress();
        enterPermenentAddress(PermenentAdress);

        submitTextBoxButton();
        Reporter.log("TextBox form submitted successfully.", true); 
    }
    
    public void EditTextBox(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        Reporter.log("Editing the TextBox form.", true);  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        clearuserName();
        enterfullNanme(userName);

        clearuserEmail();
        entercuserEmail(userEmail);

        clearcurrentAdress();
        enterCurrentAddress(currentAdress);

        clearpermenentAdress();
        enterPermenentAddress(PermenentAdress);

        submitTextBoxButton();
        Reporter.log("TextBox form submitted successfully.", true); 
    }

}
