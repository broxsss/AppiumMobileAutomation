package com.android.hybridapps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ucbrowser {

	@Test
	public void Hybridapp_test() throws MalformedURLException, InterruptedException
	{

		File appDir = new File(System.getProperty("user.dir")+"//apk");

		
		File app = new File(appDir, "com.UCB.apk");

		DesiredCapabilities cap=new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//set the package name of the app
				cap.setCapability("appPackage", "com.UCMobile.intl");
				//set the Launcher activity name of the app
				cap.setCapability("appActivity", "com.uc.browser.InnerUCMobile");
				//driver object with new Url and Capabilities

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		

	}	
}
