package QABootcamp_Maven.AxsosAcademy2;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecordInTable  {
	 
	private WebDriver driver; 
	public RecordInTable(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstNameField = By.xpath("//div[contains(normalize-space(text()), 'First Name')]"); 
	private By lastNameField = By.xpath("//div[contains(normalize-space(text()), 'Last Name')]"); 
	private By ageField  = By.xpath("//div[contains(normalize-space(text()), 'Age')]");
	private By emailField =  By.xpath("//div[contains(normalize-space(text()), 'Email')]");
	private By salaryField =  By.xpath("//div[contains(normalize-space(text()), 'Salary')]");
	private By departmentField =  By.xpath("//div[contains(normalize-space(text()), 'Department')]");
	private By actionsField =  By.xpath("//div[contains(normalize-space(text()), 'Action')]");
	private By addButton =  By.id("addNewRecordButton");
	private By searchBox =  By.id("searchBox");
	private By row =  By.xpath("//select[@aria-label = 'rows per page']");
    private By tableRows = By.xpath("//table[@id='yourTableId']//tbody//tr");
    private By closebutton = By.xpath ("//button[@class = 'close']");
	private By editButton =  By.xpath("//*[@id=\"edit-record-1\"]/svg/path");
	private By deleteButton =  By.id("edit-record-2");
	
	
	private By firstNameInput = By.xpath("//input[@id='firstName']"); 
	private By lastNameInput = By.xpath("//input[@id='lastName']"); 
	private By emailInput =  By.xpath("//input[@id='userEmail']");
	private By ageInput = By.xpath("//input[@id='age']");
	private By salaryInput =  By.xpath("//input[@id='salary']");
	private By departmentInput =  By.xpath("//input[@id='department']");
	private By submitButton =  By.xpath("//button[@id='submit']");

	



	public boolean isElementDisplayed () {
		if (driver.findElement(firstNameField).isDisplayed()
		&& driver.findElement(lastNameField).isDisplayed()
		&& driver.findElement(emailField).isDisplayed()
		&& driver.findElement(ageField).isDisplayed() 
		&& driver.findElement(salaryField).isDisplayed()
		&& driver.findElement(departmentField).isDisplayed()
		&& driver.findElement(actionsField).isDisplayed()) {return true;}
		else return false;
		}
	
	public void fillRecord (String firstName, String lastName, String Email, String age, String salary, String department) {
		driver.findElement(getFirstNameInput()).sendKeys(firstName);
		driver.findElement(lastNameInput).sendKeys(lastName);
		driver.findElement(emailInput).sendKeys(Email);
		driver.findElement(ageInput).sendKeys(age);
		driver.findElement(salaryInput).sendKeys(salary);
		driver.findElement(departmentInput).sendKeys(department);
		}
	
	public void clickSubmit () throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submitBtn = wait2.until(ExpectedConditions.elementToBeClickable(getSubmitButton()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
		Thread.sleep(5000);
		}
	public void clickEdit () throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clickeditBtn = wait2.until(ExpectedConditions.elementToBeClickable(getSubmitButton()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickeditBtn);
		
		Thread.sleep(5000);
		}
	
	public void clickOnAdd () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement AddButton = wait.until(ExpectedConditions.elementToBeClickable(getAddButton()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);

		Thread.sleep(5000);
		}

	public void clickOnClose () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);

		Thread.sleep(5000);
		}
	public void makesearch (String Email) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement searchBox2 = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBox2);
		searchBox2.click();
		searchBox2.sendKeys(Email);
		Thread.sleep(2000);
		searchBox2.clear();
		}
	
	public void addRecord (String firstName, String lastName, String Email, String age, String salary, String department) throws InterruptedException {

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	clickOnAdd();
	//WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(20));
	//wait.until(ExpectedConditions.elementToBeClickable(submitButton));
	// wait.until(ExpectedConditions.visibilityOfAllElements(button));
	fillRecord(firstName, lastName, Email, age, salary, department);
	clickSubmit();
	}


	    public void fillEditForm(String firstName, String lastName, String email, String age, String salary, String department) throws InterruptedException {
	        driver.findElement(firstNameInput).clear();
	        driver.findElement(firstNameInput).sendKeys(firstName);
	        
	        driver.findElement(lastNameInput).clear();
	        driver.findElement(lastNameInput).sendKeys(lastName);
	        
	        driver.findElement(emailInput).clear();
	        driver.findElement(emailInput).sendKeys(email);
	        
	        driver.findElement(ageInput).clear();
	        driver.findElement(ageInput).sendKeys(age);
	        
	        driver.findElement(salaryInput).clear();
	        driver.findElement(salaryInput).sendKeys(salary);
	        
	        driver.findElement(departmentInput).clear();
	        driver.findElement(departmentInput).sendKeys(department);
	        clickSubmit();	        
	    }



	    public void editRecord(String email, String firstName, String lastName, String newEmail, String age, String salary, String department) throws InterruptedException {
	    	clickEdit();
	        fillEditForm(firstName, lastName, newEmail, age, salary, department); 
	    }
	
	public By getFirstNameInput() {
		return firstNameInput;
	}

	public void setFirstNameInput(By firstNameInput) {
		this.firstNameInput = firstNameInput;
	}

	public By getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(By submitButton) {
		this.submitButton = submitButton;
	}



	public By getAddButton() {
		return addButton;
	}

	public void setAddButton(By addButton) {
		this.addButton = addButton;
	}

	public By getCloseButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
