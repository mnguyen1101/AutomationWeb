package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LoginPage {
 
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public LoginPage(WebDriver driver) {
	          this.driver = driver;
	 }
	 
	 //Locator for username field
	 By uName = By.id("login_field");
	 
	 //Locator for password field
	 By pswd = By.id("password");
	 
	 //Locator for login button
	 By loginBtn = By.name("commit");
	 //Mothod to check for firstime login
	 
	 //Locator for authorize
	 By titlAuthorize = By.xpath("//h2[@class=\"f2 text-normal text-center lh-condensed mb-4\"]");
	 By authorizeBtn = By.xpath("//button[@id=\"js-oauth-authorize-btn\"]");
	 
	 public void checkAuthorize() {
		 if ( driver.findElement(titlAuthorize) == null ) {
			 System.out.println("Account already to Authorize");
		} 
		 else {
			 System.out.println(driver.findElement(titlAuthorize).getText());
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();", authorizeBtn);
			 
					 
		 }
	 }
	 
	 //Method to enter username
	 public void enterUsername(String user) {
		 driver.findElement(uName).sendKeys(user);
	 }
	 
	 //Method to enter password
	 public void enterPassword(String pass) {
		 driver.findElement(pswd).sendKeys(pass);
	 }
	 
	 //Method to click on Login button
	 public void clickLogin() {
		 driver.findElement(loginBtn).click();
	 }
	}