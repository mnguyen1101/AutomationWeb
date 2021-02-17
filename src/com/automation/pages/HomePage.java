package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class HomePage {
	
	 WebDriver driver;
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public HomePage(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 //Locator for login button GitHub
	 By LoginBtnGit = By.xpath("//a[@class=\"btn btn-social btn-github\"]");
	 //Locator for text in Home Page
	 
	 By textHompage = By.xpath("//h1[text()=\"To continue you will need to sign in first,\"]");
	 
	 
	 //Method to click login button
	 public void clickLogin() {
		 driver.findElement(LoginBtnGit).click();
	 }
	 
	 public void movetoGitPage() {
		 
		 for(String winHandle : driver.getWindowHandles()){
		     driver.switchTo().window(winHandle);
		 }
	 }
	 
	 public void verifiedHomePageText() {
		  System.out.println("----------------Welcome to Home Page-------------------- ");	
		  System.out.println (driver.findElement(textHompage).getText());
	 }
	 
	 
	 
}
