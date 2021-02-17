package com.automation.pages;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardToDoList {
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public DashBoardToDoList(WebDriver driver) {
	          this.driver = driver;
	 }
	 
	 //Locator for logout button
	 By logoutBtn = By.xpath("//button[@class=\"btn btn-default\"]");
	 
	 //Locator for list name text box 
	 By listnameTbox = By.xpath("//div[@class=\"row\"]//input");
	 
	 //Locator for add list button
	 By addBtn = By.xpath("//div[@class=\"row\"]//button");
	 
	 //Locator for remove button
	 By removeBtn = By.xpath("//button[@class=\"btn btn-default\"]");
	 
	 //
	 By titleDashBoardTodo = By.xpath("//div[@class=\"brownhill \"]");
	 
	 //Locator for button remove
	 By allButtonRemoves =  By.xpath("(//ul[@class=\"list-group\"]//button)");
	 //Locator for item name
	 By allItemsList = By.xpath("(//ul[@class=\"list-group\"]//a)");
	 
	
	 
	 
	 
	 // Method for random item name
	 public String generateListname(int length) {		 
		    return RandomStringUtils.randomAlphabetic(length);	
	 }
	 
	 //Method for Add item name to List
	 public void InputListName() {
		 
		 for (int i = 1; i <= 10; i++)
		 {
				// Random name of item 
			 	driver.findElement(listnameTbox).click();
			 	driver.findElement(listnameTbox).sendKeys(generateListname(6));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				// Add item to Lists
				driver.findElement(addBtn).click();
				WebDriverWait wait_Add_items = new WebDriverWait(driver,20);
				wait_Add_items.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//ul[@class=\"list-group\"]//button)")+"["+ i +"]")));
				driver.findElement(listnameTbox).clear();
			}		
	 }
	 
	//Method for Print item name in List 
	 public void PrintItemsInList() {
		 for (int j = 0; j <= driver.findElements(allItemsList).size()-1; j++)  {
			 System.out.println((driver.findElements(allItemsList)).get(j).getText());
		 }
	 }
	 
	 //Method for get Title Dashboard 
	 public void verfiedDashBoardTitle() {
		 System.out.println("------------Welcome to------------ ");
		 System.out.println(driver.findElement(titleDashBoardTodo).getText());
	 }
	 //Method to remove items in List
	 public void RemoveItemsInList() {
		  //int maxlengt = driver.findElements(allButtonRemoves).size() ;
		 while ( (driver.findElements(allButtonRemoves).size() - 1) >= 5)  {
			 driver.findElements(allButtonRemoves).get(5).click();;
		 }
	 }
	 public void logoutDashboard () {
		 driver.findElement(logoutBtn).click();
		 System.out.println("=====================Log out from TODO DashBorad successfully=======================");
	 }
	 
}

