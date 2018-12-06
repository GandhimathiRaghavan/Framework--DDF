package com.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Readmyexcel;

public class testscript {
	public WebDriver driver=null;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ragha\\Myselenium-workspace\\FrameworkDemo1\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");
	}
	
	
	
	
	@Test
	
	public void login() {
		
		try {
			
			String[][] data=Readmyexcel.getdata("C:\\Users\\Ragha\\Desktop\\TestExcel.xlsx", "Sheet1");
			
			for(int i=1;i<data.length;i++) {
				String username=data[i][0];
				String password=data[i][0];
				driver.findElement(By.xpath("//input[@name='userName']")).clear();
				driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name='password']")).clear();
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	/*	String expectedresult="Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form."; 
			
		
		String actualresult=driver.findElement(By.xpath("//b[contains(text(),'Mercury Tours!')]")).getText();
		
		if(expectedresult.contains(actualresult)) 
			
			Reporter.log("Test case is passed");
			
			else
				Reporter.log("Unable to execue");
			
			driver.navigate().back();*/
				
	}
	
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
	
	

}
