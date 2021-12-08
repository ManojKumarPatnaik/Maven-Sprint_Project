package browserconfiguration;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadConfigProperties;
//Creating a class to do Browser Configurations
public class Browser
{
	//Initializing objects to the below classes and interfaces
	static WebDriver driver;
	static String path; 
	static String url;
	static ReadConfigProperties read = new ReadConfigProperties();
	
	//WebDriver Setup Selection Method
	public static WebDriver setDriver(String browserName) throws Exception
	{
		//System.out.println("If you want to change the browser go and change the browser select value in config.properties");
		
		browserName=read.getBrowserSelect();
		if(browserName.equalsIgnoreCase("chrome"))
			driver = startChromeBrowser();
		else if(browserName.equalsIgnoreCase("edge"))	
			driver = startEdgeBrowser();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver = startFirefoxBrowser();
		else
			System.out.println("invalid browser");

		driver.manage().window().maximize();
		url=read.getURL();
		driver.get(url);
		timeManager();

		return driver;
	}

	//Initializing the CHROME Driver
	public static WebDriver startChromeBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		//It will disable the notifications in the Browser
		chromeOptions.addArguments("--disable-notifications");
		//It will disable the info bars in the browser
		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	//Initializing the FIREFOX Driver
	public static WebDriver startFirefoxBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--disable-notifications");
		driver = new FirefoxDriver();

		return driver;
	}

	//Initializing the MS EDGE Driver
	public static WebDriver startEdgeBrowser()
	{
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions edgeOptions = new EdgeOptions();
		//It will disable the infobars in the Browser
		edgeOptions.setCapability("disable-infobars", false);
		//It will disable the notifications in the Browser
		edgeOptions.setCapability("--disable-notifications", true);
		driver=new EdgeDriver(edgeOptions);

		return driver;
	}
	//creating a method implicit timeout for proper execution of the application 
	public static void timeManager()
	{
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

	//Method to close the Browser
	public static void closeBrowser()
	{
		//Closing the Browser
		driver.quit();
	}

}
