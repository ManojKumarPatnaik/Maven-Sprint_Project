package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomHTMLReport {

	static FileWriter fw;
	static BufferedWriter bw1;
	static BufferedWriter bw;

	//Creating a method to build a Custom HTML Report for TestCase Report
	public static void updateResult(int indexSI, String testCaseName, String testCaseStatus, String scriptName) throws IOException
	{
		//To get time stamp of Test start Date and time
		String startDateTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String userDirector = System.getProperty("user.dir");

		//To set a path for custom HTML Report file
		String resultFile = userDirector + "\\src\\test\\resources\\CustomReports\\TestHtmlReport1.html";

		File file = new File(resultFile); 
		System.out.println(file.exists());

		//To clear the previous generated report
		if(indexSI == 1)
		{
			file.delete();	
		}

		//if file doesnot exist,then it will  generate a html file with title as testexecution report
		if (!file.exists()) {

			fw = new FileWriter(file.getAbsoluteFile(), true);

			bw = new BufferedWriter(fw);

			bw.write("<html>" + "\n");

			bw.write("<head><title>" + "Test execution report" + "</title>" + "\n");

			bw.write("</head>" + "\n");

			bw.write("<body>");

			bw.write("<font face='Tahoma'size='2'>" + "\n"); 

			bw.write("<u><h1 align='center'>" + "Test execution report" + "</h1></u>" +"\n");

			bw.flush();

			bw.close();
		}
		BufferedWriter bw1= new BufferedWriter(new FileWriter(file, true));

		//If there is a file exist then it will create rows and column for first time
		if (indexSI == 1) {

			bw1.write("<table align='center' border='0' width='50%' height='10'>");

			bw1.write("<tr><td width='50% </td></tr>");

			bw1.write("<table align='center' border='1' width='50%' height='47'>");

			bw1.write("<tr>");

			bw1.write("<td colspan='2' align='center'><b><font color='#000000' face='Tahoma' size='2'>ScriptName :&nbsp;&nbsp;&nbsp;</font></b><font color='#0000FF''  face='Tahoma' size='2'>"+scriptName+"</font></td>");

			bw1.write("<td colspan='1' align='left'><b><font color='#000000' face='Tahoma' size='2'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='2' >"+startDateTime+"</font></td>");

			bw1.write("</tr>");

			bw1.write("</tr>"); 

			bw1.write("<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");

			bw1.write("<td bgcolor='#CCCCFF' align='left'><b><font color='#000000'  face='Tahoma' size='2'>Test case ID: Test case Description </font></b></td>");

			bw1.write("<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Result </font></b></td>");

			bw1.write("<tr>");

		}
		bw1.write("<tr>" + "\n");


		bw1.write("<td bgcolor='#FFFFDC' align='Center'><font color='#000000' face='Tahoma' size='2'>" + indexSI + "</font></td>" + "\n"); 

		bw1.write("<td bgcolor='#FFFFDC valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>" + testCaseName + "</font></b></td>" + "\n");

		//if the test cases are successful it shows pass status
		if (testCaseStatus == "Pass") 
		{ 
			bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='Green' face='Tahoma' size='2'>" +testCaseStatus+"</font></b></td>"+"\n");

		} 
		//if the test cases are Fail it shows Fail status
		else 
		{
			bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='red' face='Tahoma' size='2'>" + testCaseStatus +"</font></b></td>"+"\n");
		}


		bw1.write("</tr>" + "\n");

		bw1.write("</body>" + "\n");

		bw1.write("</html>");

		//It will flush the report
		bw1.flush();

		//It will close the report
		bw1.close();
	}
}
	

