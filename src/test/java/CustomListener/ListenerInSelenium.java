package CustomListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.os.WindowsUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testCustomListener.TestBase1;

public class ListenerInSelenium extends TestBase1 implements ITestListener{

//	private static final int OutputType = 0;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("Test  has started:" + arg0.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		 
		if(!arg0.isSuccess())
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
			String methodname = arg0.getName();
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/java/";
			File destFile = new File(reportDirectory + "/failure_screenshots/" + methodname + "_" + formater.format(calendar.getTime()) + ".png"); 
			
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src ='" + destFile.getAbsolutePath() + "'height='100' width='100'/> </a>");
			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		if(arg0.isSuccess())
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
			String methodname = arg0.getName();
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/java/";
			File destFile = new File(reportDirectory + "/success_screenshots/" + methodname + "_" + formater.format(calendar.getTime()) + ".png"); 
			
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src ='" + destFile.getAbsolutePath() + "'height='100' width='100'/> </a>");
			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
