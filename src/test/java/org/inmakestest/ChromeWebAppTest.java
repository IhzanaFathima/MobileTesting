package org.inmakestest;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class ChromeWebAppTest {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException, AWTException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9PPR1.180610.011");
		cap.setCapability("deviceName", "Redmi 6");
		cap.setCapability("udid", "104faa3b7d29");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
	
		Thread.sleep(3000);
		
		try {
			
			WebElement withoutAccnt = driver.findElement(By.id("com.android.chrome:id/signin_fre_dismiss_button"));
			withoutAccnt.click();
			
		} catch (Exception e) {
			
			System.out.println("Entering Chrome through accepting the agreement");
		}
		
		try {
			
			WebElement accept = driver.findElement(By.id("com.android.chrome:id/terms_accept"));
			accept.click();
			
			WebElement noThanks = driver.findElement(By.id("com.android.chrome:id/negative_button"));
			noThanks.click();
			
		} catch (Exception e) {
			
			System.out.println("Entering Chrome without using account....");
		}
		
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//*[@text='Search or type web address']"));
		search.sendKeys("Flipkart");
		
		WebElement flipkart = driver.findElement(By.xpath("//*[@text='Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com']"));
		flipkart.click();
		
		Thread.sleep(20000);
		
		WebElement flipSearch = driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']"));
		flipSearch.click();
		//flipSearch.sendKeys("Apple Phone");
		
		Thread.sleep(10000);
		
		WebElement mobiles = driver.findElement(By.xpath("//*[@text='mobiles']"));
		mobiles.click();
		
		//WebElement searchTxt = driver.findElement(By.id("input-searchsearchpage-input"));
		//searchTxt.sendKeys("Apple Phone");
		
		//WebElement applephn = driver.findElement(By.xpath("//*[@text='apple phone']"));
		//applephn.click();
		
		Thread.sleep(10000);
		driver.quit();
	}
}

