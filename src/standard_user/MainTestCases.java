package standard_user;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	String myWebSite = "https://www.saucedemo.com";

	String userName = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(myWebSite);

		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();
	}

	@Test(priority = 1)

	public void login() {

		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(userName);
		PasswordInputField.sendKeys(passwordInput);
		LoginButton.click();
	}

	// @Test(priority = 2, enabeld = false)
	// public void AddAllItem(){
	// AddItemToCart() throws InterruptedException
	// Thread.sleep(3000);
	// driver.findElements(By.className("btn")).get(0).click();
	// driver.findElements(By.className("btn")).get(1).click();
	// driver.findElements(By.className("btn")).get(2).click();
	// driver.findElements(By.className("btn")).get(3).click();
	// driver.findElements(By.className("btn")).get(4).click();
	// driver.findElements(By.className("btn")).get(5).click();

	// List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
	// for (int i = 1; i < AddToCartButtons.size(); i=i+2) {
	// AddToCartButtons.get(i).click();
	// }

	// }

	@Test(priority = 2, enabled = false)

	public void AddCertainNumberofItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {

			if (i == 0 || i == 2) {
				continue;
			}
			AddToCartButtons.get(i).click();

		}

	}

	@Test(priority = 2, enabled = false)
	public void AddItemThatStartsWithSauce() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				continue;
			}
			AddToCartButtons.get(i).click();
		}

	}

	@Test(priority = 3, enabled = true)
	public void AddRandomItem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		int randomIndex = rand.nextInt(AddToCartButtons.size());

		System.out.println(randomIndex);

		// double randomIndex = Math.floor(Math.random()*AddToCartsButtons.size());
		// System.out.println(Math.random());
		// System.out.println(Math.floor(6.3));
		// System.out.println(Math.ceil(88.1));

		AddToCartButtons.get(randomIndex).click();
	}

	@Test(priority = 3, enabled = false)
	public void RemoveItemFromTheCart() throws InterruptedException {

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

	}

	@Test(priority = 4)
	public void Checkoutprocess() {

		WebElement ShopingCart = driver.findElement(By.className("shopping_cart_link"));
		ShopingCart.click();

		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();

		// Array of first names
		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };

		int RandomFirstName = rand.nextInt(firstNames.length);

		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };

		int RandomLastName = rand.nextInt(lastNames.length);

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };

		int RandomPostalCode = rand.nextInt(postalCodes.length);

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement LastnameInput = driver.findElement(By.id("last-name"));
		WebElement PostalcodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomFirstName]);
		LastnameInput.sendKeys(lastNames[RandomLastName]);
		PostalcodeInput.sendKeys(postalCodes[RandomPostalCode]);
		
		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
		
		WebElement BackToHome = driver.findElement(By.id("back-to-products"));
		BackToHome.click();
	}

	@AfterTest
	public void PostTesting() {

	}

}
