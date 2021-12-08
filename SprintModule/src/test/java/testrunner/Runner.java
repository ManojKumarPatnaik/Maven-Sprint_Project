package testrunner;

/**
 * @author Vusa Swarna kumar
 * @author Praveen
 * @author Kishore
 * @author Harish
 * @author Tarun
 * INTQEA21QE037
 * Technologies Implemented
 * 1.TestNG  2.Cucumber  3.Extent Report  4.Custom HTML report
 * 5.Apache POI for data driven  6.Junit  7.POM  8.Maven
 */

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"stepdefintion"},plugin= {"pretty", "html:SprintModule/report","json:SprintModulejsonreport/jsonreport.json","junit:SprintModulejunitreport/Cucumberjunit.xml"},monochrome = true)	

//CucumberJunitReports
public class Runner 				
{		

}
