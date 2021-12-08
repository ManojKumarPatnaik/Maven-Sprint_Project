package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserconfiguration.Browser;

public class HomePage {

	WebDriver driver;
	Actions actions;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void timeManager() throws Throwable 						
	{

		Browser.timeManager();

	}
	
	public void hoverToNavbar()
	{
		
		actions= new Actions(driver);
		WebElement navbar = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/div[3]/div[1]/span[1]"));//(By.className("close_menu icon-leftMeuOpen"))
		actions.moveToElement(navbar).perform();

	}
	public void clickOnsite()
	{
		WebElement onSite=driver.findElement(By.xpath("//*[@id=\'projectIcon\']/ul/li[1]/a"));
		
		WebElement project=driver.findElement(By.xpath("//*[@id='projectIcon']/span"));
		if(onSite.isDisplayed())
		{
			onSite.click();
		}
		else if(project.isDisplayed()){
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(project));

		onSite.click();
		}
	}

		public void clickSprint()
		{
		actions.moveToElement(driver.findElement(By.id("LOCK_Plan"))).build().perform();

		driver.findElement(By.id("LOCK_Sprints")).click(); 
	

		}


	}

