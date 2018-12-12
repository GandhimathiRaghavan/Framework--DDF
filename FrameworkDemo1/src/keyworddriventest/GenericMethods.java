package keyworddriventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GenericMethods {

	public static WebDriver driver= null;
	
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ragha\\Myselenium-workspace\\FrameworkDemo1\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
	}
	public static void maximizeWindow() {
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public static void implementWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
	}
	
	public static void NavigateTo(String url) {
		
		driver.get(url);
		
	}
	
	public static void  invalidUsername(String locator,String value,String param) {
		
		
		if(locator.equals("id")) {
			
			driver.findElement(By.id(value)).sendKeys(param);
		}
		
		else
		{
			driver.findElement(By.name(value)).sendKeys(param);
		}
		
		
		
	}
	
	public static void invalidPassword(String locator,String value,String param) {
		
		if(locator.equals("id")) {
			driver.findElement(By.id(value)).sendKeys(param);
		}
		else
		{
			driver.findElement(By.name(value)).sendKeys(param);
		}
	}
	
	public static void clickSubmit(String locator,String value) {
		
		if(locator.equals("xpath")) {
		
		driver.findElement(By.xpath(value)).click();
		}
		else
		{
			driver.findElement(By.id(value)).click();
		}
		
		
		
	}
	
	public static void verifyMessage(String locator,String value,String param) {
		
		String expectedMessage=param;
		String actualMessage=null;
		
		if(locator.equals("xpath")) {
			
			actualMessage=driver.findElement(By.xpath(value)).getText();
			}
			else
			{
				driver.findElement(By.id(value)).click();
			}
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	public static void closeBrowser() {
		
		driver.close();
			
	}
	

}
