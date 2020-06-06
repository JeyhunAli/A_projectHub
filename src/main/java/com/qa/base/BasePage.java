package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author jey
 * base page responsible for providing with the driver
 * this method is used to initialize the driver on the bases of the 
 * given browsser name 
 *
 */

public class BasePage {

	WebDriver driver;
	Properties prop;
	public ElementUtil elementUtil;
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	
	


	public WebDriver init_driver(Properties prop) {
		
		String browserName =  prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			//driver = new ChromeDriver();
		}

		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			//driver = new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
			//driver = new SafariDriver();
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		getDriver().get(prop.getProperty("url"));
		
		

   return getDriver();



	}
	
	/**
	 * this method is used to initialize properties from config.properties file 
	 * for that first creating object of the properties in the class level so its global level
	 * then creating object of the fileinputstream class then passing path of the 
	 * config.properties file 
	 * then surronding with try catch block and returning prop
	 * 
	 * file path here u see ./ it means current directory of your file path 
	 * 
	 * @return prop
	 */
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
	
	/**
	 * 
	 * this method will take screenshot
	 * 
	 * first getting getdriver then typecasting it, converting to TakeScreenShot interface
	 * then applying getscreen shot as method then output type as file then stroring them in src file 
	 * then importing 
	 * then we are creating one method it will create folder in our project then it will place the 
	 * screenshot 
	 * for that first need to reach to project directory 
	 * user.dir is the directory 
	 * its common so if i will assign this project to anyone they can use it 
	 * then + add screenshot file everytime then millisecond concept it will generate exact time frame
	 * 
	 * everytime when it takes screenshot it will create one folder and time stand 
	 * after all my screenshot is inside of the src file i have to convert it to the path for that
	 * creating object of the file and passing path as param 
	 * then using copy utulity 
	 * 
	 * 
	 * in extentlistener im extending base page why because my screenshot method is over there when 
	 * any of my test case will fail it will take an screenshot 
	 * 
	 * even inside extent report listener im using threadlocal driver concept so it will run parallel 
	 * and all the test cases will have one thread they will not ovveride all the reports inside to each other
	 * 
	 * 
	 * another thing extentreport listener is holding screenshot method on failure and skipped test 
	 * cases 
	 * any time ypu can comment it out when no need to use 
	 * 
	 * 
	 * @return 
	 * 
	 */
	
	public String getScreenshot() {
		
	File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	
	String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
	
	File destination = new File(path);
	
	try {
		FileUtils.copyFile(src, destination );
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		return path;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
