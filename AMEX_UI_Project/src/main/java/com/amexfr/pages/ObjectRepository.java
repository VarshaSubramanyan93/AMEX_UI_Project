package com.amexfr.pages;

import org.openqa.selenium.By;

public class ObjectRepository {

	public static String chromeDriver = "webdriver.chrome.driver";
	public static String chromeDriverPath = "C:\\Users\\varsh\\Documents\\Projects\\chromedriver-win64\\chromedriver.exe";

	public static String chromePath = "C:\\Users\\varsh\\Documents\\Projects\\chrome-win64\\chrome.exe";

	public static By acceptAllPopUp = By.id("user-consent-management-granular-banner-accept-all-button");

	public static String amexHomepage = "https://www.americanexpress.com/fr/?inav=NavLogo";

	public static By cartesAmex = By.xpath("(//div[@class='dls-card margin-1-b-md-up pad-1-r'])[1]");

	public static By carteGoldEnSavoir = By.xpath(
			"(//a[@class='btn btncomp links-item    display-block margin-1-b margin-center  ']/span[text()='En savoir plus'])[2]");

	public static By demandezVotreCarte = By.xpath(
			"//a[@href='https://www.americanexpress.com/fr/3534?intlink=fr-amex-cardshop-details-apply-GoldCardAmericanExpress-siderail']");

	public static By namePrefixMme = By.xpath("//div[@class=' css-6grebl']/label/span[text()='Mme']");
	public static By firstName = By.id("fieldControl-input-firstName");
	public static By lastName = By.id("fieldControl-input-lastName");
	public static By dob = By.id("fieldControl-input-dateOfBirth");
	public static By email = By.id("fieldControl-input-email");
	public static By countryCode = By.id("countryCode");
	public static By phoneNumber = By.id("fieldControl-input-mobilePhoneNumber");
	public static By sauvegarderButton = By.xpath("//button[@class='css-19hct2l']");

}
