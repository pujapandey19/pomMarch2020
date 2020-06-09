package com.qa.hubspot.base;

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

public class BasePage {

	public static ThreadLocal<WebDriver>tlDriver= new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	
	
	/**
	 * 
	 * @author puja 
	 * This method is used to initialize the web driver on the basis of given browser
	 *         
	 * 
	 * @param browserName
	 * @return driver
	 *
	 */
	


	WebDriver driver;
	Properties prop;
	public ElementUtil elementUtil;

	public WebDriver init_driver(Properties prop) {
		
		String browsername=prop.getProperty("browser");

		// WebDriverManager.chromedriver().setup();
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhendu\\Desktop\\my work\\chromedriver.exe");
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());

		} else if (browsername.equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			
			
			

		} else if (browsername.equalsIgnoreCase("Safari")) {
			//driver = new SafariDriver();
			
				tlDriver.set(new SafariDriver());
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	/**
	 * This method is used to initialize the properties from config.properties file
	 * 
	 * @return prop
	 */
	public Properties init_prop() {
		// create object of properties class
		// create object of FileInputStream class
		// load the prop
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return prop;

	}

	
	/**
	 * 
	 *This method will take the screenshot
	 *
	 *
	 */
	
	public String getScreenshot() {
		
		
		File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		
		File destination= new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return path;
		
	}
}
