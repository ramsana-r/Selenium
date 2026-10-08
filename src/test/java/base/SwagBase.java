package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.SwagCartPage;
import page.SwagCheckoutPage;
import page.SwagHomePage;
import page.SwagLoginPage;


public class SwagBase {
	
	
	public static WebDriverWait wait;
	public static WebDriver driver;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public SwagLoginPage login;
	public SwagHomePage home;
	public SwagCartPage cart;
	public SwagCheckoutPage checkout;
	
	@BeforeTest
	public void setUp()
	{
		reporter=new ExtentSparkReporter("./Report/myreport1.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows10");
		extent.setSystemInfo("testername", "abc");
		extent.setSystemInfo("Browsername", "chrome");
			
		ChromeOptions options=new ChromeOptions();
		//incognito
		options.addArguments("--incognito");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}
	@BeforeMethod
	public void beforemthd(Method mthd)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		login=new SwagLoginPage(driver);
		home=new SwagHomePage(driver);
		cart=new SwagCartPage(driver);
		checkout=new SwagCheckoutPage(driver);
		test=extent.createTest(mthd.getName());//common line for display the testname
		
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case failed is"+result.getName());
			test.log(Status.FAIL, "test case failed is"+result.getThrowable());
			String screenshotpath=screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "test case skipped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "test case passed is"+result.getName());
		}
		
	}
	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./Screenshots/"+screenshotname+".jpeg";
		FileHandler.copy(src, new File(destination));
		return destination;
	}
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
	
}
