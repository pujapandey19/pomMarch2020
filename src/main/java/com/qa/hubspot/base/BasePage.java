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
import com.qa.hubspot.utils.OptionsManager;

public class BasePage {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

	/**
	 * 
	 * @author puja This method is used to initialize the web driver on the basis of
	 *         given browser
	 * 
	 * 
	 * @param browserName
	 * @return driver
	 *
	 */

	WebDriver driver;
	Properties prop;
	public ElementUtil elementUtil;
	public OptionsManager optionsManager;

	public WebDriver init_driver(Properties prop) {

		optionsManager = new OptionsManager(prop);
		String browsername = prop.getProperty("browser");

		// WebDriverManager.chromedriver().setup();
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhendu\\Desktop\\my work\\chromedriver.exe");
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		} else if (browsername.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		} else if (browsername.equalsIgnoreCase("Safari")) {
			// driver = new SafariDriver();

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
	 * on the basis of the given env variable
	 * 
	 * @return prop
	 */
	public Properties init_prop() {
		// create object of properties class
		// create object of FileInputStream class
		// load the prop
		prop = new Properties();
		String path = null;
		String env = null;

		try {

			env = System.getProperty("env");
			System.out.println("env value is : " + env);

			if (env == null) {
				path = "src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";// Execution is going on prod env

			} else {
				switch (env) {
				case "qa":
					path = "src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					break;

				case "dev":
					path = "src\\main\\java\\com\\qa\\hubspot\\config\\dev.config.properties";
					break;

				default:
					System.out.println("Please pass the correct environment :" + env);
					break;

				}
			}
			FileInputStream ip = new FileInputStream(path);
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
	 * This method will take the screenshot
	 *
	 *
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
