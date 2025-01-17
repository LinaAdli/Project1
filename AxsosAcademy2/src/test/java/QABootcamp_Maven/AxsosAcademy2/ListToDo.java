package QABootcamp_Maven.AxsosAcademy2;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager; 
public class ListToDo {

	@Test
	public  void Test () {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");
			driver.manage().window().maximize();
		
			
			WebElement fillbox = driver.findElement(By.xpath("//input[@class = 'new-todo ng-pristine ng-valid ng-touched']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'new-todo ng-pristine ng-valid ng-touched']")));
			//WebElement box = wait.until(ExpectedConditions.elementToBeClickable(fillbox));
			fillbox.click();
			fillbox.sendKeys("Add two items");
			fillbox.sendKeys(Keys.RETURN);
			fillbox.click();
			fillbox.sendKeys("Delete");
			fillbox.sendKeys(Keys.RETURN);
			
			
			List<WebElement> myElements = driver.findElements(By.xpath("/html/body/app-root/section/app-todo-list/main/ul/app-todo-item[1]/li"));

			List<String> actualMenu =new ArrayList<>();
			for(WebElement menuItems: myElements){ 
				actualMenu.add(menuItems.getText()); 
				Assert.assertEquals(menuItems.getSize(),2, "Mismatch in number of menu items");
				
				
				//System.out.println(actualMenu);
			}
			WebElement Completeone = driver.findElement(By.xpath("//div[@class= 'view']/button"));
			Completeone.click();
			
			WebElement FilterCompleted = driver.findElement(By.xpath("//a[@class= 'selected']"));
			FilterCompleted.click();
			
			List<WebElement> myElements2 = driver.findElements(By.xpath("/html/body/app-root/section/app-todo-list/main/ul/app-todo-item[1]/li"));

			for(WebElement menuItems2: myElements2){ 
				actualMenu.add(menuItems2.getText()); 
				Assert.assertEquals(menuItems2.getSize(),1, "Mismatch in number of menu items");
				//System.out.println(actualMenu);
			}
			
			WebElement closeitem = driver.findElement(By.xpath("//div[@class= 'view']//button[@class = 'destroy']"));
				Actions action = new Actions(driver);
				action.moveToElement(closeitem).perform();
				action.click();
				
			
			
			
			//div[@class= 'view']//button[@class = 'destroy']
			
			} catch (Exception e) {
			 e.printStackTrace();
				}
		}

	
}

			
	
	
