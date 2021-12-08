

package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


//Creating a class to Read data from Config properties file
public class ReadConfigProperties
{
	FileInputStream fis = null;
	Properties prop = null;

	//Setting properties file for input
	public Properties inputSetup()
	{
		//Assiging config.properties file location
		String filelocation = System.getProperty("user.dir") + "\\ObjectRepository\\config.properties";
		File file = new File(filelocation);

		try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	//to return the URL from properties file
		public String getURL()
		{
			inputSetup();
			String URL = prop.getProperty("URL");
			return URL;
		}
		
		//To return the browser select value from config properties file
		public String getBrowserSelect() 
		{
			inputSetup();
			String k = prop.getProperty("browserselect");
			return k;
		}
		
		//to return the ChromeDriver location from properties file
		public String getChromeDriverLocation()
		{
			inputSetup();
			String location = prop.getProperty("chromeDriver");
			return location;
		}
		//to return the FirefoxDriver location from properties file
		public String getFirefoxLocation()
		{
			inputSetup();
			String location = prop.getProperty("firefoxDriver");
			return location;
		}
		//to return the edgeDriver location from properties file
		public String getEdgeDriverLocation() 
		{
			inputSetup();
			String location = prop.getProperty("edgeDriver");
			return location;
		}
		


}
