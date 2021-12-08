package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.ScreenShotRob;


public class SprintPage {
	WebDriver driver;
	
	public SprintPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void verifySprintPageTitle()
	{
		String expectedTitle="mainspring";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void clickAddSprint()
	{
		driver.findElement(By.id("KEY_BUTTON_Add-btnIconEl")).click();

	}
	public void switchToFrame()
	{
		driver.switchTo().frame(driver.findElement(By.id("contentframe")));
	}
	public void setName(String name) 
	{
		
		driver.findElement(By.name("CM_Name")).sendKeys(name);

	}

	public void selectSpringType(String type)
	{
		
		Select sType=new Select(driver.findElement(By.id("DN_SprintType1")));
		sType.selectByValue(type);
	}

	public void selectRelease(String releaseTitle)
	{
		
		Select sRelease=new Select(driver.findElement(By.name("CM_Release")));
		sRelease.selectByVisibleText(releaseTitle);
	}

	public void setStartDate(String startDate)
	{
		
		driver.findElement(By.id("STARTDATE")).sendKeys(startDate);

	}
	public void setEndDate(String endDate)
	{

		driver.findElement(By.id("ENDDATE")).sendKeys(endDate);

	}
	public void setResponsibleName(String resName)
	{
		Select respName=new Select(driver.findElement(By.id("DN_Responsibility")));
		respName.selectByValue(resName);
	}
	public void setTeamsinvolved(String numTeams)
	{

		driver.findElement(By.id("DN_NoofTeamsinvolved")).sendKeys(numTeams);
	}
	public void setCapacity(String numCapacity)
	{

		driver.findElement(By.id("CAPACITY")).sendKeys(numCapacity);

	}
	public void selectTeam(String team)
	{

		Select sTeam=new Select(driver.findElement(By.id("AG_SCRUM_TEAM")));
		sTeam.selectByValue(team);
	}
	public void clickSave() throws Exception
	{

		driver.findElement(By.id("SaveBtn")).click();
		Thread.sleep(5);

	}
	public boolean takescreenshot() {
		try {
			ScreenShotRob.captureScreenShot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public void handleAlert() throws Exception 
	{
		Alert alert=driver.switchTo().alert();
		String alertMesg =alert.getText();
		System.out.println(alertMesg);
		System.out.println("=========================================================================");
		alert.accept();
	}
	
	public int handleAlert2() throws Exception 
	{
		int num=1;
		Alert alert=driver.switchTo().alert();
		String alertMesg =alert.getText();
		return num;
	}
	
	  public void handleAlert1() throws Exception { 
		  
	  Alert alert=driver.switchTo().alert(); 
	  alert.accept(); 
	  }
	 

	public void verifySprintCreation()
	{

		String sprintId = null;
		WebElement sId=	driver.findElement(By.id("CM_ItemCode"));
		sprintId=sId.getText();
		System.out.println(sprintId);
	}
	public void returnToSprint()
	{
		driver.findElement(By.id("CancelBtn")).click();
	}

}
