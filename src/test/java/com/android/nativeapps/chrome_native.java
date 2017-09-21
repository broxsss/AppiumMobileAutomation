package com.android.nativeapps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class chrome_native {
	@Test
	public void Hybridapp_test() throws MalformedURLException, InterruptedException
	{

		File appDir = new File(System.getProperty("user.dir")+"//apk");

		
		File app = new File(appDir, "com.chrome.apk");

		DesiredCapabilities cap=new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//set the package name of the app
				cap.setCapability("appPackage", "com.android.chrome");
				//set the Launcher activity name of the app
				cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
				//driver object with new Url and Capabilities

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		driver.findElement(By.id("terms_accept")).click();
		driver.findElement(By.id("next_button")).click();
		driver.findElement(By.id("negative_button")).click();
		driver.findElement(By.id("search_box_text")).click();
		driver.findElement(By.id("url_bar")).sendKeys("facebook.com");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		System.out.println("facebook is opened");
		System.out.println(driver.getContext());
		Set<String> language = driver.getContextHandles();
		for(String lang :language)
		{
			System.out.println(lang);
			if(lang.contains("English"))
			{
				driver.location();
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='m_login_email']")).sendKeys("akshay");

		

	}	
}
