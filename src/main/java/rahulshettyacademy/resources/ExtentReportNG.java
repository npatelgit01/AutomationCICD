package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
		String file = System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setReportName("Web Automation Report");
		report.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester Name", "Nimisha Patel");
		return extent;
	}

}
