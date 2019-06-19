import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOnAndroid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		
		
		String chromedriverPath = "D:\\FinalLeadFootTestTool\\ChromeDriverVersions\\chromedriver2.44.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
       // capabilities.setCapability("browserName", "android");
        capabilities.setCapability("VERSION", "4.4.2"); 
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("fixSessionCapabilities", false);
        //capabilities.setCapability("homepage", "http://www.google.com");
      //  "homepage" : "http://www.google.com" 
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--no-first-run");
      
        
    
        
        
    //capabilities.setCapability("appPackage", "com.android.chrome");
 // This package name of your app (you can get it from apk info app)
      //  capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main"); // This is Launcher activity of your app (you can get it from apk info app)
 //Create RemoteWebDriver instance and connect to the Appium server
        //options.setExperimentalOption("homepage" , "http://www.google.com");
        
//        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        
        
        
       // options.setExperimentalOption("skip_first_run_ui", "true");
        //options.setExperimentalOption("show_welcome_page", "false");
        //options.setExperimentalOption("androidPackage", "com.android.chrome");
      //  options.setExperimentalOption("androidDeviceSerial", "emulator-5554");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    
    
   // WebDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    
    
    
    googleSearch(driver);				

	}
	
	public WebDriver getMobileChromeDriver() {
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
	    chromeOptions.setExperimentalOption("androidDeviceSerial", "emulator-5554");
	    return new ChromeDriver(chromeOptions);
	}
	
	
	private static DesiredCapabilities getNewCapabilities()
	{
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("device","android");

	        capabilities.setCapability("app","chrome");
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	        capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
	        capabilities.setCapability("deviceName","test");
	      //  capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
	        capabilities.setCapability("platformName","Android");
	        capabilities.setCapability("app-package", "com.android.chrome");
	        capabilities.setCapability("app-activity", ".com.google.android.app.chrome.Mains");
	        return capabilities;
	        
	}
	
	private static void googleSearch(WebDriver driver) throws InterruptedException
	{
		//Open URL in Chrome Browser
		driver.get("http://www.google.com");
		
		 WebElement element = driver.findElement(By.name("q"));
		    element.sendKeys("Cheese!\n"); // send also a "\n"
		  //  element.submit();
		    Thread.sleep(10000);
	}

}



/*
 * public void beforeTest( ) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
 */
