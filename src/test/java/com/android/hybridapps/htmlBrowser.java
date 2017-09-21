package com.android.hybridapps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import junit.framework.Assert;

public class htmlBrowser {




	@Test
	public void Hybridapp_test() throws MalformedURLException, InterruptedException
	{

		File appDir = new File(System.getProperty("user.dir")+"//apk");

		
		File app = new File(appDir, "org.firefox.apk");

		DesiredCapabilities cap=new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//set the package name of the app
				cap.setCapability("appPackage", "org.mozilla.firefox");
				//set the Launcher activity name of the app
				cap.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");
				//driver object with new Url and Capabilities

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		driver.findElement(By.id("url_bar_entry")).click();
		driver.findElement(By.id("url_bar_entry")).sendKeys("facebook.com");
		String notificatn = driver.findElement(By.id("suggestions_prompt_title")).getText();
		System.out.println(notificatn);
		if(notificatn.contains("Would you like"))
		{
			driver.findElement(By.id("suggestions_prompt_no")).click();	
		}
		Thread.sleep(3000);
		//driver.getKeyboard().pressKey("ENTER");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		System.out.println("facebook is opened");
		System.out.println(driver.getContext());
		Set<String> con = driver.getContextHandles();
		
		for(String context :con)
		{
			System.out.println(context);
			
		}
		driver.context("WebView_com.example.nativeapp");
		driver.findElement(By.xpath(".//*[@id='m_login_email']")).sendKeys("akshay");
		driver.findElement(By.xpath(".//*[@id='m_login_password']")).sendKeys("idontknow");
		driver.findElement(By.xpath(".//*[@id='u_0_5']")).click();
		Thread.sleep(5000);
		String login_fail = driver.findElement(By.xpath(".//*[@id='u_0_0']/div[1]")).getText();
		System.out.println(login_fail);
		Assert.assertEquals("The password you entered is incorrect. Did you forget your password?", login_fail);
		System.out.println("Test case passed....");
		driver.close();
	}
}