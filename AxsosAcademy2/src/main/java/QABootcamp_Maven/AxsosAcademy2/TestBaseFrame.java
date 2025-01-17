
package QABootcamp_Maven.AxsosAcademy2;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager; 

public class TestBaseFrame {
	protected WebDriver driver; 
	private static String baseUrl ="https://demoqa.com/frames";
		 
		 @BeforeTest 
		 public void setup(){  
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get(baseUrl); 
		 }
		 @AfterTest
		 public void tearDown(){ 
			 if(driver !=null) {
				 driver.quit(); }
			 }
		 }
		 
