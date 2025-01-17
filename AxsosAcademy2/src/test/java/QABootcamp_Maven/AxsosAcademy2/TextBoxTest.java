package QABootcamp_Maven.AxsosAcademy2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import QABootcamp_Maven.AxsosAcademy2.TestBase2;

public class TextBoxTest extends TestBase2 {

    private TextBox addTextBox2;
    private OutputAddTextBox outputAddTextBox;

    @BeforeMethod
    public void setuppage () {
        addTextBox2 = new TextBox(driver);
        outputAddTextBox = new OutputAddTextBox(driver);
        Reporter.log("Page setup completed.", true);
    }

    @Test(priority = 1, dataProvider = "validInfo")
    public void addNewTextBoxTest(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        TextBox textBox1 = new TextBox(driver);
        OutputAddTextBox output = new OutputAddTextBox(driver);

        Reporter.log("Entering data: UserName=" + userName + ", UserEmail=" + userEmail + ", Current Address=" + currentAdress + ", Permanent Address=" + PermenentAdress, true);
        textBox1.AddNewTextBox(userName, userEmail, currentAdress, PermenentAdress);
        
        Reporter.log("Verfity the output...", true);
        Assert.assertTrue(output.getOutputUserName().contains(userName), "User Name output does not match User Name input");
        Assert.assertTrue(output.getOutputEmail().contains(userEmail), "User Email output does not match User Email input");
        Assert.assertTrue(output.getOutputCurrentAddress().contains(currentAdress), "Current Address output does not match Current Address input");
        Assert.assertTrue(output.getOutputPermanentAddress().contains(PermenentAdress), "Permanent Address output does not match Permanent Address input");
        
        Reporter.log("Output UserName: " + output.getOutputUserName(), true);
        Reporter.log("Output UserEmail: " + output.getOutputEmail(), true);
        Reporter.log("Output Current Address: " + output.getOutputCurrentAddress(), true);
        Reporter.log("Output Permanent Address: " + output.getOutputPermanentAddress(), true);

        driver.navigate().refresh();
        Thread.sleep(1000);
        
        Reporter.log("Test completed for valid input.", true);
    }

    @Test(priority = 2, dataProvider = "validInfoforedit")
    public void editTextBoxTest(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        TextBox textBox1 = new TextBox(driver);
        OutputAddTextBox output = new OutputAddTextBox(driver);

        Reporter.log("Entering data: UserName=" + userName + ", UserEmail=" + userEmail + ", Current Address=" + currentAdress + ", Permanent Address=" + PermenentAdress, true);
        textBox1.EditTextBox(userName, userEmail, currentAdress, PermenentAdress);

        Reporter.log("Verfity the output...", true);
        Assert.assertTrue(output.getOutputUserName().contains(userName), "User Name output does not match User Name input");
        Assert.assertTrue(output.getOutputEmail().contains(userEmail), "User Email output does not match User Email input");
        Assert.assertTrue(output.getOutputCurrentAddress().contains(currentAdress), "Current Address output does not match Current Address input");
        Assert.assertTrue(output.getOutputPermanentAddress().contains(PermenentAdress), "Permanent Address output does not match Permanent Address input");
        
        Reporter.log("Output UserName: " + output.getOutputUserName(), true);
        Reporter.log("Output UserEmail: " + output.getOutputEmail(), true);
        Reporter.log("Output Current Address: " + output.getOutputCurrentAddress(), true);
        Reporter.log("Output Permanent Address: " + output.getOutputPermanentAddress(), true);

        Thread.sleep(1000);
        
        Reporter.log("Test completed for valid input.", true);
    }

    @Test(priority = 3, dataProvider = "InvalidInfoforedit")
    public void addInvalidTextBoxTest(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        TextBox textBox2 = new TextBox(driver);
        OutputAddTextBox output2 = new OutputAddTextBox(driver);

        Reporter.log("Entering invalid data: UserName=" + userName + ", UserEmail=" + userEmail + ", Current Address=" + currentAdress + ", Permanent Address=" + PermenentAdress, true);
        textBox2.AddNewTextBox(userName, userEmail, currentAdress, PermenentAdress);
        
        WebElement outputUserName = driver.findElement(By.xpath("//div[@id ='output']//p[@id='name']"));
        Reporter.log("Output UserName: " + outputUserName.getText(), true);

        if ((userName == null || userEmail == null || currentAdress == null || PermenentAdress == null)) {
            boolean status = false;
            Assert.assertEquals(status, false, "One/or more of input fields are null.");
            Reporter.log("Invalid input", true);
        }

        Assert.assertFalse(output2.getOutputUserName().contains(userName), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputEmail().contains(userEmail), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputCurrentAddress().contains(currentAdress), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputPermanentAddress().contains(PermenentAdress), "TextBox should not be added with invalid data.");
        Assert.assertFalse(outputUserName.getText().contains(userName), "TextBox should not be added with invalid data.");
        
        driver.navigate().refresh();
        Thread.sleep(1000);
        
        Reporter.log("Test completed for invalid input.", true);
    }
    
    @Test(priority = 4, dataProvider = "InValidInfo")
    public void editInvalidTextBoxTest(String userName, String userEmail, String currentAdress, String PermenentAdress) throws InterruptedException {
        TextBox textBox2 = new TextBox(driver);
        OutputAddTextBox output2 = new OutputAddTextBox(driver);

        Reporter.log("Editing - Entering invalid data: UserName=" + userName + ", UserEmail=" + userEmail + ", Current Address=" + currentAdress + ", Permanent Address=" + PermenentAdress, true);
        textBox2.EditTextBox(userName, userEmail, currentAdress, PermenentAdress);
        
        WebElement outputUserName = driver.findElement(By.xpath("//div[@id ='output']//p[@id='name']"));
        Reporter.log("Output UserName: " + outputUserName.getText(), true);

        if ((userName == null || userEmail == null || currentAdress == null || PermenentAdress == null)) {
            boolean status = false;
            Assert.assertEquals(status, false, "One of input fields are null.");
            Reporter.log("Invalid input", true);
        }

        Assert.assertFalse(output2.getOutputUserName().contains(userName), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputEmail().contains(userEmail), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputCurrentAddress().contains(currentAdress), "TextBox should not be added with invalid data.");
        Assert.assertFalse(output2.getOutputPermanentAddress().contains(PermenentAdress), "TextBox should not be added with invalid data.");
        Assert.assertFalse(outputUserName.getText().contains(userName), "TextBox should not be added with invalid data.");
        
        driver.navigate().refresh();
        Thread.sleep(1000);
        
        Reporter.log("Test completed for invalid input.", true);
    }

    @DataProvider(name = "validInfo")
    public Object[][] provideValidTextBoxData() {
        return new Object[][]{
            {"Lina Adli", "linaadli2024@gmail.com", "Nablus-Palestine", "Nabuls-Palestine"},
            {"Ahmad-Abd-Al'leem", "Ahmad-abd@gmail.com", "Rafeida-Street. Nablus", "Nabuls/Palestine."}
        };
    }
    
    @DataProvider(name = "validInfoforedit")
    public Object[][] provideValidTextBoxDataforedit() {
        return new Object[][]{
            {"Lina Ramahi", "lina@hotmail.com", "Nablus", "Nabuls"},
        };
    }
    @DataProvider(name = "InvalidInfoforedit")
    public Object[][] provideinValidTextBoxDataForEdit() {
        return new Object[][]{
            {"2", "linaadli2024.com", "0", "1"},
            {" ", " ", "Rafeida-Street. Nablus", "Nabuls/Palestine."},
            {" ", "Jameel", "Ramallah", "Ramallah"}

        };}
    
    @DataProvider(name = "InValidInfo")
    public Object[][] provideinValidTextBoxData() {
        return new Object[][]{
            {"", "linaadli2024", "Nabuls-Palestine", "Nabuls-Palestine"},
            {"123%", "Samah@gmail.com", "Jericho-Palestine", "Jenin-Palestine"},

            //{"", "", "Nabuls-Palestine" , "Nabuls-Palestine"},
            //{"Lina", "", "Nabuls-Palestine" , "Nabuls-Palestine"},
            //{"", "", "Nabuls-Palestine" , "Nabuls-Palestine"},
        };
    }
}
