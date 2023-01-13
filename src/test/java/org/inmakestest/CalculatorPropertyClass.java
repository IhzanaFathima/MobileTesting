package org.inmakestest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPropertyClass {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Manaf\\eclipse-workspace2\\AppiumClass\\Files\\config.properties");
		p.load(fis);
		
		cap.setCapability("platformName", p.getProperty("platformName"));
		cap.setCapability("platformVersion", p.getProperty("platformVersion"));
		cap.setCapability("deviceName", p.getProperty("deviceName"));
		cap.setCapability("udid", p.getProperty("udid"));
		cap.setCapability("appPackage", p.getProperty("appPackageCalculator") );
		cap.setCapability("appActivity", p.getProperty("appActivityCalculator"));
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
	
		WebElement agree = driver.findElement(By.id(p.getProperty("agree")));
		agree.click();
		
		WebElement nine = driver.findElement(By.id(p.getProperty("nine")));
		nine.click();
		
		WebElement add = driver.findElement(By.id(p.getProperty("add")));
		add.click();
		
		WebElement seven = driver.findElement(By.id(p.getProperty("seven")));
		seven.click();
		
		WebElement equal = driver.findElement(By.id(p.getProperty("equal")));
		equal.click();
		
		
	}
}
