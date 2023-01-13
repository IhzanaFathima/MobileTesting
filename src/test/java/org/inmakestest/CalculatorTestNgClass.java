package org.inmakestest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorTestNgClass {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	
	@BeforeClass
	private void launchBrowser() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9PPR1.180610.011");
		cap.setCapability("deviceName", "Redmi 6");
		cap.setCapability("udid", "104faa3b7d29");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		WebElement agree = driver.findElement(By.id("android:id/button1"));
		agree.click();
	}
	
    @Test(priority=1)
	private void testcase01() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nine.click();
		
		WebElement seven = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		seven.click();
	}
	
	@Test(priority=3)
	private void testcase02() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement seven = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		seven.click();
		
		WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nine.click();
	}
	
	@Test(priority=2)
	private void testcase03() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		add.click();
	}

	@Test(priority=4)
	private void testcase04() throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		WebElement equal = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		equal.click();
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f= new File("./Screenshot\\calculator.png");
		FileUtils.copyFile(img, f);
	}	
		
	@BeforeMethod
	private void startDate() {
         
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterMethod
	private void endDate() {
		
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterClass
	private void quitBrowser() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
}
