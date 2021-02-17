package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.config.BrowserConfig;
import com.automation.pages.DashBoardToDoList;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MainTest {
	WebDriver driver ;
	
	String path = System.getProperty("user.dir");
	
	HomePage homepage;
	
	LoginPage loginpage;
	
	DashBoardToDoList dashboard;
	
	  
	
@BeforeClass
		public void beforeClass() {
		
		 System.setProperty("webdriver.chrome.driver",path + "\\driverbrowser\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://todo-list-login.firebaseapp.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	@Test (priority=1)
		public void Step1_LoginGitHub() {
		  String winHandleBefore = driver.getWindowHandle();
		  homepage = new HomePage(driver);
		  homepage.clickLogin();
		  homepage.movetoGitPage();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  loginpage = new LoginPage(driver);
		  loginpage.enterUsername("mnguyen1101"); //change input user_name
		  loginpage.enterPassword("Mn0938371022");//change input password
		  loginpage.clickLogin();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  loginpage.checkAuthorize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.switchTo().window(winHandleBefore);
	  }
  
  
	@Test (priority=2)
		public void Step2_addItemsList() throws InterruptedException {
		  dashboard = new DashBoardToDoList(driver);
		  dashboard.verfiedDashBoardTitle();
		  dashboard.InputListName();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  System.out.println("========================Displayed All Items After Add List:=================================");
		  dashboard.PrintItemsInList();
		  // upon completion log out
		  dashboard.logoutDashboard();
		  homepage.verifiedHomePageText();
		  Thread.sleep(5000);
		  
	
	  }
  
	@Test (priority=3)
		public void Step3_removeItemsList() throws InterruptedException {
		  //login again with same account
		  homepage.clickLogin();
		  dashboard = new DashBoardToDoList(driver);
		  dashboard.verfiedDashBoardTitle();
		  //Remove items in List
		  dashboard.RemoveItemsInList();
		  System.out.println("===========Displayed All Items After Remove items (5-10)=====================");
		  dashboard.PrintItemsInList();
		  //Log out from DashBoard
		  dashboard.logoutDashboard();	
		  Thread.sleep(5000);
		  homepage.verifiedHomePageText();
	  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
