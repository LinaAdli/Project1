package QABootcamp_Maven.AxsosAcademy2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutputAddTextBox {
    private WebDriver driver;

    private By outputUserName = By.id("name");
    private By outputEmail = By.id("email");
	private By outputCurrentAddress  = By.xpath("//p[@id='currentAddress']");
	private By outputPermanentAddress=  By.xpath("//p[@id='permanentAddress']");
 
    public OutputAddTextBox(WebDriver driver) {
        this.driver = driver;
    }

    public String getOutputUserName() {
        WebElement userNameElement = driver.findElement(outputUserName);
        return userNameElement.getText();
    }

    public String getOutputEmail() {
        WebElement emailElement = driver.findElement(outputEmail);
        return emailElement.getText();
    }

    public String getOutputCurrentAddress() {
        WebElement currentAddressElement = driver.findElement(outputCurrentAddress);
        return currentAddressElement.getText();
    }

    public String getOutputPermanentAddress() {
        WebElement permanentAddressElement = driver.findElement(outputPermanentAddress);
        return permanentAddressElement.getText();
    }
}