package com.android.hybridapps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class htmlBrowser {




	@Test
	public void Hybridapp_test() throws MalformedURLException, InterruptedException
	{

		File appDir = new File(System.getProperty("user.dir")+"//apk");

		
		File app = new File(appDir, "com.htmlview.apk");

		DesiredCapabilities cap=new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		/* boolean warmsg =driver.findElement(By.id("startup_permission_dialog_tips_title")).isDisplayed();
		if(warmsg)
		{
			driver.findElement(By.id("startup_permission_dialog_tips_close_button")).click();
		}
		*/
		driver.findElement(By.id("radioButton2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("editText1")).sendKeys("facebook.com");
		Thread.sleep(3000);
		driver.findElement(By.id("button2")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='locale-selector']/div/div[2]/div[1]/span/a")));
		
		System.out.println("facebook is opened");
		List<String> language = driver.findElements(By.xpath("*//a"));
		for(String lang :language)
		{
			System.out.println(lang);
			if(lang.contains("English"))
			{
				driver.location();
			}
		}
		
		
	}
}