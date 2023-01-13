package org.inmakestest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class FirstTestCalculator {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException {

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
		
		WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nine.click();
		
		WebElement add = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		add.click();
		
		WebElement seven = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		seven.click();
		
		WebElement equal = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		equal.click();
	}
}
