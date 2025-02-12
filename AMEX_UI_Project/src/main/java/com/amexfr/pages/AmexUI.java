package com.amexfr.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmexUI {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public void setUp() {

		System.setProperty(ObjectRepository.chromeDriver, ObjectRepository.chromeDriverPath);

		ChromeOptions options = new ChromeOptions();

		options.setBinary(ObjectRepository.chromePath);
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void popUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement acceptAll = driver.findElement(ObjectRepository.acceptAllPopUp);
		acceptAll.click();
	}

	@Test(priority = 1)
	public void openHomePage() {
		driver.get(ObjectRepository.amexHomepage);
		Assert.assertTrue(driver.getTitle().contains("American Express"), "Homepage not opened.");
	}

	@Test(priority = 3)
	public void clickCartesAmericanExpress() {
		popUp();
		WebElement cartesLink = driver.findElement(ObjectRepository.cartesAmex);
		cartesLink.click();
	}

	@Test(priority = 4)
	public void openAllCardsPage() throws InterruptedException {
		popUp();
		WebElement enSavoirPlusButton = driver.findElement(ObjectRepository.carteGoldEnSavoir);
		enSavoirPlusButton.click();
	}

	@Test(priority = 5)
	public void openGoldCardDescriptionPage() {
		WebElement demandezVotreCarteButton = driver.findElement(ObjectRepository.demandezVotreCarte);
		demandezVotreCarteButton.click();
	}

	@Test(priority = 6)
	public void fillUserDetails() throws InterruptedException {
		WebElement namePrefix = driver.findElement(ObjectRepository.namePrefixMme);
		namePrefix.click();

		WebElement firstName = driver.findElement(ObjectRepository.firstName);
		firstName.sendKeys("Varsha");

		WebElement lastName = driver.findElement(ObjectRepository.lastName);
		lastName.sendKeys("Subramanyan");

		WebElement dob = driver.findElement(ObjectRepository.dob);
		dob.sendKeys("03/01/1993");

		WebElement email = driver.findElement(ObjectRepository.email);
		email.sendKeys("varshachuva@gmail.com");

		Select dropdown = new Select(driver.findElement(ObjectRepository.countryCode));
		dropdown.selectByValue("Inde");

		WebElement phoneNumber = driver.findElement(ObjectRepository.phoneNumber);
		phoneNumber.sendKeys("123456789");

		WebElement element = driver.findElement(ObjectRepository.sauvegarderButton);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		WebElement sauvegarderButton = driver.findElement(ObjectRepository.sauvegarderButton);
		sauvegarderButton.click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
