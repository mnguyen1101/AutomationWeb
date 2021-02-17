package com.automation.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {
	WebDriver driver;
	String path = System.getProperty("user.dir");
	
	//Constructor that will be automatically called as soon as the object of the class is created
		 public BrowserConfig(WebDriver driver) {
		          this.driver = driver;
		 }
		 
		 public void runbyChrome( String url) {
			 System.setProperty("webdriver.chrome.driver",path+ "\\driverbrowser\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 }
}
