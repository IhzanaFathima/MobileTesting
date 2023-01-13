package org.inmakestest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class MynthraHybridAppTest {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9PPR1.180610.011");
		cap.setCapability("deviceName", "Redmi 6");
		cap.setCapability("udid", "104faa3b7d29");
		cap.setCapability("appPackage", "com.myntra.android");
		cap.setCapability("appActivity", "com.myntra.android.SplashActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
	
		Thread.sleep(5000);
		
		WebElement profile = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"tabButton_profile\"]/android.widget.TextView"));
		profile.click();
		
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//*[@text='LOG IN/SIGN UP']"));
		login.click();
		
		Thread.sleep(3000);
		WebElement mobile = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"mobile\"]"));
		mobile.sendKeys("1234567890");
		
		WebElement continueButn = driver.findElement(By.xpath("//*[@text='CONTINUE']"));
		continueButn.click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
