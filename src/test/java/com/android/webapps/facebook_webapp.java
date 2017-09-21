package com.android.webapps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import junit.framework.Assert;

public class facebook_webapp {

	
	@Test
	public void webapp_test() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Going to start Browser....");
		System.out.println("Browser started...");
		driver.get("https://m.facebook.com/?refsrc=https%3A%2F%2Fwww.facebook.com%2F&_rdr");
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
