package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Common;

public class PorschePage {

	private WebDriver driver;
	
	@BeforeClass
	
	public void setUp() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.porsche.com/usa/modelstart/");
		
	}
	@Test
	public void test() {
		Common.sleep(1);
		 driver.findElement(By.cssSelector("[alt='Porsche - Panamera']")).click();
		 Common.sleep(2);
//		 driver.findElement(By.xpath("(//span[text()='Sport '])[2]")).click();
		
		scroll(driver);
        Actions action=new Actions(driver);
      
		 WebElement hover=driver.findElement(By.xpath("(//span[text()='Sport '])[2]"));
     	 action.moveToElement(hover).click().perform();
//		 jse.executeScript("window.scrollBy(0,500)")

//		 scroll(driver);
				 
		 driver.findElement(By.xpath("//span[text()='All wheel drive']")).click();
//		 action.moveToElement(hover1).click().perform();
		 
		 Common.sleep(2);
		 
		 driver.findElement(By.cssSelector("[alt='Porsche Panamera Turbo S E-Hybrid Sport Turismo']")).click();
		 
	}
	
	public void scroll(WebDriver driver) {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,1000)");
	}
	
	@AfterTest
	public void tearDown() {
		Common.sleep(5);
		driver.quit();
	}
}
