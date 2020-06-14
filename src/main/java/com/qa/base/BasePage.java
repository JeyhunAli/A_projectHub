package com.qa.base;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import com.qa.hubspot.utils.ElementUtil;
//import com.qa.hubspot.utils.OptionsManager;




//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
///**
// * 
// * @author jey
// * base page responsible for providing with the driver
// * this method is used to initialize the driver on the bases of the 
// * given browsser name 
// *
// */
//
//public class BasePage {
//
//	WebDriver driver;
//	public Properties prop;
//	public ElementUtil elementUtil;
//	public OptionsManager optionsManager;
//	
//	
//	
//	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
//	
//	public static synchronized WebDriver getDriver() {
//		return tlDriver.get();
//		
//	}
//	
//	
//	public WebDriver init_driver(Properties prop) {
//		
//		
//		
//		/**
//		 * 
//		 * this method is defining one logic that 
//		 * lets say if im not passing any env var for example browser name on the terminal 
//		 * then execute as a normal take the browser from config.properties file 
//		 * but if im passing any env browser value then come to else part take the browser from environment
//		 * logic from getproperty 
//		 */
//		
//		
//		String browserName = null;
//		if (System.getProperty("browser") == null) {
//			browserName = prop.getProperty("browser");
//		} else {
//			browserName = System.getProperty("browser");
//		}
//
//		System.out.println("Running on --->" + browserName + " browser");
//		
//		optionsManager = new OptionsManager(prop);
//		
//		
//		// String browserName =  prop.getProperty("browser");
//		
//
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
//			//driver = new ChromeDriver();
//		}
//
//		if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
//			//driver = new FirefoxDriver();
//		}
//
//		else if(browserName.equalsIgnoreCase("safari")) {
//			WebDriverManager.getInstance(SafariDriver.class).setup();
//			tlDriver.set(new SafariDriver());
//			//driver = new SafariDriver();
//		}
//
//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().window().maximize();
//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		getDriver().get(prop.getProperty("url"));
//		
//		
//
//   return getDriver();
//
//
//
//	}
//	
//	/**
//	 * this method is used to initialize properties from config.properties file 
//	 * for that first creating object of the properties in the class level so its global level
//	 * then creating object of the fileinputstream class then passing path of the 
//	 * config.properties file 
//	 * then surronding with try catch block and returning prop
//	 * 
//	 * file path here u see ./ it means current directory of your file path 
//	 * 
//	 * 
//	 * below in new code im trying to explain that if there multiple env 
//	 * i can run my test cases accordingly 
//	 * for example if the given value is qa, dev or stage or maybe its prod env 
//	 * according that i can execute the test cases 
//	 * for that im using if else condition with  the swith case 
//	 * first env and path value are null then with the getproperty method imm getting 
//	 * env 
//	 * 
//	 * @return prop
//	 */
//	
//	public Properties init_prop() {
//		
//		prop = new Properties();
//		
//		String path = null;
//		String env = null;
//		
//		try {
//			
//			env = System.getProperty("env");
//			System.out.println("env value is ---- " + env);
//			
//			if(env == null) {
//				path = "./src/main/java/com/qa/config/config.properties";
//			}
//			else {
//				switch (env) {
//				case "qa":
//					path = "./src/main/java/com/qa/config/qa.config.properties";
//					break;
//				case "dev":
//					path = "./src/main/java/com/qa/config/dev.config.properties";
//					break;
//				case "stage":
//					path = "./src/main/java/com/qa/config/stage.config.properties";
//					break;
//
//				default:
//					System.out.println("please pass the correct env "+env);
//					break;
//				}
//			}
//			
//			
//			FileInputStream ip = new FileInputStream(path);
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return prop;
//		
//		
//	}
//	
//	/**
//	 * 
//	 * this method will take screenshot
//	 * 
//	 * first getting getdriver then typecasting it, converting to TakeScreenShot interface
//	 * then applying getscreen shot as method then output type as file then stroring them in src file 
//	 * then importing 
//	 * then we are creating one method it will create folder in our project then it will place the 
//	 * screenshot 
//	 * for that first need to reach to project directory 
//	 * user.dir is the directory 
//	 * its common so if i will assign this project to anyone they can use it 
//	 * then + add screenshot file everytime then millisecond concept it will generate exact time frame
//	 * 
//	 * everytime when it takes screenshot it will create one folder and time stand 
//	 * after all my screenshot is inside of the src file i have to convert it to the path for that
//	 * creating object of the file and passing path as param 
//	 * then using copy utulity 
//	 * 
//	 * 
//	 * in extentlistener im extending base page why because my screenshot method is over there when 
//	 * any of my test case will fail it will take an screenshot 
//	 * 
//	 * even inside extent report listener im using threadlocal driver concept so it will run parallel 
//	 * and all the test cases will have one thread they will not ovveride all the reports inside to each other
//	 * 
//	 * 
//	 * another thing extentreport listener is holding screenshot method on failure and skipped test 
//	 * cases 
//	 * any time ypu can comment it out when no need to use 
//	 * 
//	 * 
//	 * @return 
//	 * 
//	 */
//	
//	public String getScreenshot() {
//		
//	File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
//	
//	String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
//	
//	File destination = new File(path);
//	
//	try {
//		FileUtils.copyFile(src, destination );
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//		
//		return path;
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	
//
//}









import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * 
 *
 */
public class BasePage {

	WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to initialize the WebDriver on the basis of browser
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = null;
		if (System.getProperty("browser") == null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");
		}

		System.out.println("Running on --->" + browserName + " browser");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browserName);
			}
			else {
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browserName);
			}
			else {
				tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
				
			}
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();

		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	private void init_remoteWebDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getFireFoxOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * this method is used to initialize the properties from config.proeprties
	 * file on the basis of given env variable
	 * 
	 * 
	 * @return prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			System.out.println("env value is--->" + env);
			if (env == null) {
				path = "./src/main/java/com/qa/hubspot/config/config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "./src/main/java/com/qa/hubspot/config/qa.config.properties";
					break;
				case "dev":
					path = "./src/main/java/com/qa/hubspot/config/dev.config.properties";
					break;
				case "stage":
					path = "./src/main/java/com/qa/hubspot/config/stage.config.properties";
					break;
				default:
					System.out.println("Please pass the correct env value----> " + env);
					break;
				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * this method will take the screenshot
	 */
	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}

























