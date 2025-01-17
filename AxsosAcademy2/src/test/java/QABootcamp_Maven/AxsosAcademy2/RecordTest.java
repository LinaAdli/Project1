package QABootcamp_Maven.AxsosAcademy2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import QABootcamp_Maven.AxsosAcademy2.RecordInTable;
import QABootcamp_Maven.AxsosAcademy2.TestBaseRecord;
import org.testng.Reporter;

public class RecordTest extends TestBaseRecord {

    private RecordInTable addRecord2;

    @BeforeMethod
    public void setuppage () {
        Reporter.log("Setting up the page", true);  
        addRecord2 = new RecordInTable(driver);
    }

    @Test(priority = 1)
    public void VisibilityElementsInTable () throws InterruptedException {
        Reporter.log("Check the visibility of elements in the table.", true);  
        RecordInTable table = new RecordInTable(driver);
        boolean isElementVisible = table.isElementDisplayed();
        Assert.assertEquals(true, isElementVisible);
        Reporter.log("Web Table elements are displayed.", true); 
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void AddSbumitButtonsTest() throws InterruptedException {
        Reporter.log("Check the visibility and functionality of Add and Submit buttons.", true); 
        RecordInTable table = new RecordInTable(driver);
        WebElement addButtonElement = driver.findElement(table.getAddButton());
        Assert.assertTrue(addButtonElement.isDisplayed(), "Add button is not visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addButtonElement));
        Assert.assertTrue(addButtonElement.isEnabled(), "Add button is not clickable.");
        table.clickOnAdd();
        WebElement firstNameInputField = driver.findElement(table.getFirstNameInput());
        Assert.assertTrue(firstNameInputField.isDisplayed(), "First Name input field is not visible after clicking Add button.");
        WebElement submitButton = driver.findElement(table.getSubmitButton());
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not visible after clicking Add button.");
        Reporter.log("Add and Submit buttons are checked ", true);  
        Thread.sleep(1000);
    }

    @Test(priority = 3, dataProvider = "validInfo")
    public void addNewRecordTest(String firstName, String lastName, String Email, String age, String salary, String department, boolean expected) throws InterruptedException {
        Reporter.log("Check adding a new record with valid information.", true);  
        RecordInTable record1 = new RecordInTable(driver);
        OutputAddRecord output = new OutputAddRecord(driver);
        record1.addRecord(firstName, lastName, Email, age, salary, department);
        Assert.assertEquals(expected, output.isRecordAdded(firstName, lastName, Email, age, salary, department), "User Name output does not match User Name input");
        Reporter.log("New record added successfully with valid information.", true);  
        Thread.sleep(1000);
    }
    @Test(priority = 4, dataProvider = "validInfo")
    public void SearchTestofExistingEmail(String firstName, String lastName, String Email, String age, String salary, String department, boolean expected) throws InterruptedException {
        Reporter.log("Testing search functionality.", true); 
        RecordInTable record3 = new RecordInTable(driver);
        OutputAddRecord output3 = new OutputAddRecord(driver);
        record3.addRecord(firstName, lastName, Email, age, salary, department);
        Thread.sleep(1000);
        record3.makesearch(Email);
        boolean result3 = output3.isSearchFunctions(firstName, lastName, Email, age, salary, department);
        Assert.assertEquals(true, result3);
        Reporter.log("Search functions well.", true);  
    }

    
    @Test(priority = 5, dataProvider = "InvalidInfo")
    public void addNewInvalidRecordTest(String firstName, String lastName, String Email, String age, String salary, String department, boolean expected) throws InterruptedException {
        Reporter.log("Verify adding a new record with invalid information.", true); 
        RecordInTable record1 = new RecordInTable(driver);
        OutputAddRecord output = new OutputAddRecord(driver);
        record1.addRecord(firstName, lastName, Email, age, salary, department);
        Assert.assertEquals(expected, output.isRecordAdded(firstName, lastName, Email, age, salary, department), "User Name output does not match User Name input");
        Reporter.log("New record with invalid information.", true);  
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modalHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header']")));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and @class='close']")));
        closeButton.click();
        Thread.sleep(1000);
    }

//    @Test(priority = 3, dataProvider = "validEditData")
//    public void testEditRecord(String originalEmail, String firstName, String lastName, String newEmail, String age, String salary, String department, boolean expected) throws InterruptedException {
//        Reporter.log("Verify the edit functionality for an existing record.", true);  
//        RecordInTable recordInTable = new RecordInTable(driver);
//        recordInTable.editRecord(originalEmail, firstName, lastName, newEmail, age, salary, department);
//        OutputAddRecord output = new OutputAddRecord(driver);
//        boolean isUpdated = output.isRecordUpdated(firstName, lastName, newEmail, age, salary, department);
//        Assert.assertEquals(isUpdated, expected, "Record was not updated correctly.");
//        Reporter.log("Record edited successfully.", true); 
//    }

   
   

    @Test(priority = 6)
    public void testCloseButtonFunctionality1() throws InterruptedException {
        Reporter.log("Testing the Close button functionality in the modal.", true);  
        RecordInTable record = new RecordInTable(driver);
        record.clickOnAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modalHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header']")));
        Assert.assertTrue(modalHeader.isDisplayed(), "Modal header is not displayed.");
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and @class='close']")));
        Assert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed.");
        Assert.assertTrue(closeButton.isEnabled(), "Close button is not clickable.");
        closeButton.click();
        Thread.sleep(5000);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-header']")));
            Reporter.log("Modal successfully closed.", true);  
        } catch (TimeoutException e) {
            Reporter.log("Modal is not closed.", true);  
        }
    }



    @DataProvider(name = "validInfo")
    public Object[][] provideValidTableData() {
        return new Object[][]{
            {"Lina", "Adli", "linaadli2024@gmail.com", "30", "5000", "dep", true},
            {"Sireen", "Adli", "Sireen_new@gmail.com", "30", "5000", "dep", true}
        };
    }

    @DataProvider(name = "InvalidInfo")
    public Object[][] provideinValidTableData() {
        return new Object[][]{
            {"--", "Adli", "linaadli2024@gmail.com", "30", "5000", "dep", false},
            {"124", "Adli", "Rana-adli2024@gmail.com", "0", "5000", "dep", false},
            {"Rana", "Adli", "mail.com", "0.2", "5000", "dep", false}
        };
    }

    @DataProvider(name = "rowValues")
	public Object[][] provideRowValues() {
		 return new Object[][] {
			 {"5"},
			 {"10"},
			     };
			 }
	 
	 @DataProvider(name = "validEditData")
	    public Object[][] provideValidEditData() {
	        return new Object[][] {
	        	  {"lina", "Ramahi", "lina-adli2024@hotmail.com", "40", "6000", "dep1", true},
	        };
	    }
	}