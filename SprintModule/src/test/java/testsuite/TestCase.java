package testsuite;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utils.ScreenShotRob;
import browserconfiguration.Browser;
import pages.HomePage;
import pages.SprintPage;
import utils.CustomHTMLReport;
import utils.ExcelConfiguration;
import utils.ReadConfigProperties;

public class TestCase {
	//initializing objects to the classes and interface
	WebDriver driver;
	HomePage page;
	SprintPage spage;
	ExcelConfiguration read=new ExcelConfiguration();
	ReadConfigProperties read1 = new ReadConfigProperties();
	Date date = new Date();
	ScreenShotRob ssPath;
	String reportName = date.toString().replace(":", "").replace(" ", "") + ".html";
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "src\\ExtendReports\\ResultReport" + reportName);
	ExtentReports extent= new ExtentReports();;
	ExtentTest test,test1;
	int indexSI =1;
	String spath=ScreenShotRob.returnPath();
	@BeforeMethod(groups= {"BaseMethods"})
	@Parameters({"browser"})
	public void callingBrowser(String browserName) throws Throwable
	{
		extent.attachReporter(htmlReporter);
		driver=Browser.setDriver(browserName);
		htmlReporter.config().setDocumentTitle("Sprint Module");
		htmlReporter.config().setReportName("Sprint Module Testing");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "chrome");
		test = extent.createTest("Page launch Testcase");
		read1.getBrowserSelect();
		page =new HomePage(driver);
		test.log(Status.PASS, "Page Launched");
		page.timeManager();
		page.hoverToNavbar();
		page.clickOnsite();
		test.log(Status.PASS, "Clicked on OnSite");
		page.clickSprint();
		test.log(Status.PASS, "Clicked on Sprint");
		

	}

	//========================Valid Scenario============================
	@Test(priority = 1)
	public void test0() throws Throwable
	{
		test = extent.createTest("Valid Testcase");
		spage=new SprintPage(driver);
		spage.clickAddSprint();
		test.log(Status.PASS, "Clicked on Add Sprint");
		spage.switchToFrame();
		spage.setName(read.getData(0, 1, 0));
		test.log(Status.PASS, "Giving Name to Sprint");
		spage.selectSpringType(read.getData1(0, 1, 1));
		test.log(Status.PASS, "Selecting Sprint Type");
		spage.selectRelease(read.getData(0, 1, 2));
		test.log(Status.PASS, "Selected the Release");
		spage.setStartDate(read.getData(0, 1, 3));
		test.log(Status.PASS, "Selected the Start Date");
		spage.setEndDate(read.getData(0, 1, 4));
		test.log(Status.PASS, "Selected the End Date");
		spage.setResponsibleName(read.getData1(0, 1, 5));
		test.log(Status.PASS, "Selected Responsible Name");
		spage.setTeamsinvolved(read.getData1(0, 1, 6));
		test.log(Status.PASS, "Given No of Teams Involved");
		spage.selectTeam(read.getData1(0, 1, 7));
		test.log(Status.PASS, "Given Team Size");
		spage.setCapacity(read.getData1(0, 1, 8));
		test.log(Status.PASS, "Given Capacity");
		spage.clickSave();
		Thread.sleep(5000);
		CustomHTMLReport.updateResult(indexSI++,"ValidTestReport","Pass","Sprint Page Test");
		spage.handleAlert();
		test.log(Status.PASS, "Alert Handled");
		test.log(Status.PASS,"Saved Sprint");
		
	}

	//========================InValid Scenario1============================
	@Test(priority =2)
	public void test1() throws Throwable
	{
		test1 = extent.createTest("Invalid Testcase");
		spage=new SprintPage(driver);
		spage.clickAddSprint();
		test1.log(Status.PASS, "Clicked on Sprint");
		spage.switchToFrame();
		test1.log(Status.PASS, "Moved to Sprint Page");
		spage.setName(read.getData(0, 2, 0));
		test1.log(Status.PASS, "Set the Name");
		spage.selectRelease(read.getData(0, 2, 2));
		test1.log(Status.PASS, "Selected the Release");
		spage.setStartDate(read.getData(0, 2, 3));
		test1.log(Status.PASS, "Selected the Start Date");
		spage.setEndDate(read.getData(0, 2, 4));
		test1.log(Status.PASS, "Selected the End Date");
		spage.setResponsibleName(read.getData1(0, 2, 5));
		test1.log(Status.PASS, "Selected Responsoble Name");
		spage.setTeamsinvolved(read.getData1(0, 2, 6));
		test1.log(Status.PASS, "Given No of Teams Involved");
		spage.selectTeam(read.getData1(0, 2, 7));
		test1.log(Status.PASS, "Given Team Size");
		spage.setCapacity(read.getData1(0, 2, 8));
		test1.log(Status.PASS, "Given Capacity ");
		spage.clickSave();
		test1.log(Status.PASS, "Clicked on Save");
		Thread.sleep(5000);
		int k=spage.handleAlert2(); 
		//It will check the test case condition pass/fail and generates report as per result
		if(k==1)
			CustomHTMLReport.updateResult(indexSI++,"InValidTestReport","Pass","Sprint Page Test");
		else
			CustomHTMLReport.updateResult(indexSI++,"InValidTestReport","Fail","Sprint Page Test");	
		spage.takescreenshot();
		test1.addScreenCaptureFromPath(spath);
		spage.handleAlert();
		Thread.sleep(5000); 
		test.log(Status.PASS, "Alert Handled");
		spage.returnToSprint();
		Thread.sleep(5000);
		spage.handleAlert1();
		test.log(Status.PASS, "Pop-up Handled");



	}

	//creating a AfterTest annotation to call the close browser method
	@AfterMethod(groups= {"BaseMethods"}) 
	public void closingBrowser() 
	{
		Browser.closeBrowser();
		extent.flush();
	}

}