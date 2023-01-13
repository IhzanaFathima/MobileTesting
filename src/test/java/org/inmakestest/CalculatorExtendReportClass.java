package org.inmakestest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorExtendReportClass {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	@SuppressWarnings("rawtypes")
	
	@BeforeSuite
	private void launchBrowser() throws IOException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		htmlreporter= new ExtentHtmlReporter("calculatorReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		test = extent.createTest("Android", "Calculator Application");
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
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium click the agree button");
		WebElement agree = driver.findElement(By.id(p.getProperty("agree")));
		agree.click();
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium click the number nine");
		WebElement nine = driver.findElement(By.id(p.getProperty("nine")));
		nine.click();
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium click the add sign");
		WebElement add = driver.findElement(By.id(p.getProperty("add")));
		add.click();
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium click the number seven");
		WebElement seven = driver.findElement(By.id(p.getProperty("seven")));
		seven.click();
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium click equal sign");
		WebElement equal = driver.findElement(By.id(p.getProperty("equal")));
		equal.click();
	}
	
	@Test(priority=1)
	private void testCase1() throws InterruptedException {
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium write the testcase 01");
		System.out.println("TestCase 01");
	}
	
	@Test(priority=2)
	private void testCase2() throws InterruptedException {
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium write the testcase 02");
		System.out.println("TestCase 02");
	}
		
	@AfterSuite
	private void quitBrowser() throws InterruptedException {
		
		Thread.sleep(3000);
		test.log(Status.PASS, "Appium quit the apk");
		extent.flush();
		driver.quit();
	}
}
