package stepdefintion;

import org.openqa.selenium.WebDriver;

import browserconfiguration.Browser;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.SprintPage;
import utils.ExcelConfiguration;
import utils.ReadConfigProperties;

public class Steps {				

	WebDriver driver;
	HomePage page;
	SprintPage spage;
	ExcelConfiguration read=new ExcelConfiguration();
	ReadConfigProperties read1 = new ReadConfigProperties();
	@Given("^Open the Browser and launch the application$")
	public void open_the_Browser_and_launch_the_application() throws Throwable 						
	{	
		String browserName=read1.getBrowserSelect();
		driver=Browser.setDriver(browserName);			
	}		
	@When("^enter the homepage$")
	public void enter_the_homepage() throws Throwable 						
	{

		page =new HomePage(driver);
		page.timeManager();
		page.hoverToNavbar();
		page.clickOnsite();
		page.clickSprint();

	}	

	@When("^click on Add Sprint$")
	public void click_on_Add_Sprint() throws Throwable 
	{
		spage=new SprintPage(driver);
		spage.clickAddSprint();
	}

	@When("^enter valid data$")
	public void enter_valid_data() throws Throwable 
	{
		spage.switchToFrame();
		spage.setName(read.getData(0, 1, 0));
		spage.selectSpringType(read.getData1(0, 1, 1));
		spage.selectRelease(read.getData(0, 1, 2));
		spage.setStartDate(read.getData(0, 1, 3));
		spage.setEndDate(read.getData(0, 1, 4));
		spage.setResponsibleName(read.getData1(0, 1, 5));
		spage.setTeamsinvolved(read.getData1(0, 1, 6));
		spage.selectTeam(read.getData1(0, 1, 7));
		spage.setCapacity(read.getData1(0, 1, 8));

	}

	@When("^enter invalid data$")
	public void enter_invalid_data() throws Throwable 
	{
		spage.switchToFrame();
		spage.setName(read.getData(0, 2, 0));
		spage.selectRelease(read.getData(0, 2, 2));
		spage.setStartDate(read.getData(0, 2, 3));
		spage.setEndDate(read.getData(0, 2, 4));
		spage.setResponsibleName(read.getData1(0, 2, 5));
		spage.setTeamsinvolved(read.getData1(0, 2, 6));
		spage.selectTeam(read.getData1(0, 2, 7));
		spage.setCapacity(read.getData1(0, 2, 8));
	}

	@When("^click on save$")
	public void click_on_save() throws Throwable 
	{
		spage.clickSave();
		Thread.sleep(5000);
		spage.handleAlert();
	}

	@Then("^close the Browser$")
	public void close_the_Browser() throws Throwable
	{
		Browser.closeBrowser();  
	}		

}