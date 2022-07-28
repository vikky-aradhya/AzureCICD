package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
	}

	@Test(priority = 1)
	public void getTitle() {
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title: " + actualTitle);

		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@Test(priority = 2)
	@Parameters({ "userName", "password" })
	public void login(String userName, String password) throws Exception {

		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
