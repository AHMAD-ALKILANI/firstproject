package problem_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	
WebDriver driver = new ChromeDriver();
	
	
	String myWebSite = "https://www.saucedemo.com";
	
	String userName = "problem_user";
	String passwordInput = "secret_sauce";
	
	@BeforeTest
	
	public void MySetup() {
		
		driver.get(myWebSite);
		
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
	}
	
	
	
	@Test(priority = 1)
	
	public void login() {
		
	 driver.findElement(By.id("user-name")).sendKeys(userName);
	 driver.findElement(By.id("password")).sendKeys(passwordInput);
	 driver.findElement(By.id("login-button")).click();
	}
	
	
	@Test(priority = 2)
	
	public void AddToCartItem() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	}	
		
	
	@Test(priority = 3)
	public void RemoveItemFromTheCart() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		
	}
		
	
	
	
	@AfterTest
	public void PostTesting() {
		
	}


}
