package com.android.nativeapps;


import java.io.File;
import  java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class appium {
	WebDriver driver;
	@BeforeClass
	public void setUp() throws Exception {

		 File appDir = new File(System.getProperty("user.dir")+"//apk");
		//File app = new File(appDir, "testapp.apk");
		File app = new File(appDir, "ContactManager.apk");
		
		//To create an object of Desired Capabilities

		DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		capability.setCapability("device","Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "Android");
		//Mobile OS version. In My case its running on Android 7.1.2

		capability.setCapability(CapabilityType.VERSION, "7.1.2");
		capability.setCapability("app", app.getAbsolutePath());
		//To Setup the device name
		capability.setCapability("deviceName","oneplus3");
		capability.setCapability("platformName","Android");
		//set the package name of the app
		//capability.setCapability("app-package", "com.example.android.contactmanager-1");
		//set the Launcher activity name of the app
		//capability.setCapability("app-activity", ".ContactManager");
		//driver object with new Url and Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
	}

	@Test

	public void testApp() throws MalformedURLException, InterruptedException{

		System.out.println("App launched");

		// locate Add Contact button and click it

		
		WebElement addContactButton = driver.findElement(By.id("addContactButton"));


		addContactButton.click();

		//locate input fields and type name and email for a new contact and save it

		List<WebElement>textFields = driver.findElements(By.className("android.widget.EditText"));
        
		Thread.sleep(3000);
		textFields.get(0).sendKeys("Akshay kumar saini");
		
		Thread.sleep(3000);

		textFields.get(1).sendKeys("7417224365");

		textFields.get(2).sendKeys("bros@gmail.com");
		driver.findElement(By.id("contactSaveButton")).click();
		//insert assertions here
		
	}
	
}
