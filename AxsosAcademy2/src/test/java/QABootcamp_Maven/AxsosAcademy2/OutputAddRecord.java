package QABootcamp_Maven.AxsosAcademy2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutputAddRecord {
    private WebDriver driver;
    public OutputAddRecord(WebDriver driver) {
        this.driver = driver;
    }
    //private By outputUserName = By.id("name");
    //private By outputEmail = By.id("email");
	//private By outputCurrentAddress  = By.xpath("//p[@id='currentAddress']");
	//private By outputPermanentAddress=  By.xpath("//p[@id='permanentAddress']");
 
    
	public boolean isRecordAdded(String firstName, String lastName, String email, String age, String salary, String department) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.rt-tr"))); 
	    List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tr"));

	    for (WebElement row : rows) {
	        if (row.getText().contains(firstName) && row.getText().contains(lastName) && row.getText().contains(email) && row.getText().contains(age) && row.getText().contains(salary) && row.getText().contains(department) ) {
	            return true; 
	        }
	    }
	    return false; 
	}
	
	public boolean isSearchFunctions(String firstName, String lastName, String email, String age, String salary, String department) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.rt-tr"))); 
	    List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tr"));

	    for (WebElement row : rows) {
	        if (row.getText().contains(firstName) && row.getText().contains(lastName) && row.getText().contains(email) && row.getText().contains(age) && row.getText().contains(salary) && row.getText().contains(department) ) {
	            return true; 
	        }
	    }
	    return false; 
	}


	public boolean isRecordUpdated(String firstName, String lastName, String newEmail, String age, String salary,
			String department) {
		// TODO Auto-generated method stub
		return false;
	}

}