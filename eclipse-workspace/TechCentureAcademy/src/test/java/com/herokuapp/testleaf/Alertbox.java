package com.herokuapp.testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Common;


/**
 * February,11.2020
 * @author jahangirahmadov
 *
 */
public class Alertbox {

	private WebDriver driver;
	
//  public static void main(String[] args) {
//  String text = "   ddd   dad       ";
//  System.out.println(text.replaceAll(" ", ""));
//outcome daddad
	//}	
	@BeforeClass
	public void setUp() {
		
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(Testleaf.baseUrl+"/Alert.html");
			}
		
	/**
     * Click the button to display a alert box
     */
	@Test
	public void Test1(){
		
		By buttonLocator=By.xpath("//button[text()='Alert Box']");
		driver.findElement(buttonLocator).click();
		Common.sleep(2);
		
		driver.switchTo().alert().accept();
		Common.sleep(2);
		
//      org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : I am an alert box!}
//      driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        
        /*
         * In case of no Alert Window is Present, driver.switchTo().alert() action will fail with the
         * org.openqa.selenium.NoAlertPresentException: no such alert --> Exception
         */
        //driver.switchTo().alert()
//          accept() --> click 'OK' button
        //    .accept();
        

	}
		@Test 
		public void Test2() {
			driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
			Common.sleep(2);
			
			driver.switchTo().alert().accept();
			String resultText= driver.findElement(By.id("result")).getText();
			System.out.println(resultText);
			
			Assert.assertEquals(resultText, "You pressed OK!");
			
// to press Cancel
			
			driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
			Common.sleep(2);
			
			driver.switchTo().alert().dismiss();
			
			resultText= driver.findElement(By.id("result")).getText();
			System.out.println(resultText);
			
			Assert.assertEquals(resultText, "You pressed Cancel!");
			Common.sleep(3);
		}
		
		@Test
		public void Test3() {
			driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
			Common.sleep(2);
			
			driver.switchTo().alert().sendKeys("TECH CENTURE");
			Common.sleep(2);
			driver.switchTo().alert().accept();
			
			Common.sleep(2);
			
// to press Cancel
			driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
			
			
			driver.switchTo().alert().dismiss();
			
			Common.sleep(2);
			
		}
		
		 /**
	     * Click the button to learn line-breaks in an alert.
	     */
		@Test
		
		public void Test4() {
			
			driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
			 Common.sleep(2);
			 
			 String lineText=driver.switchTo().alert().getText();
			 System.out.println(lineText);
			 
			driver.switchTo().alert().accept();
			
			Common.sleep(2);
			
			
			//System.out.println("Hello\nHow are you doing today?");
			
			// or
			
			System.out.println(lineText.replace("\n", " "));
			
			}
		
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
