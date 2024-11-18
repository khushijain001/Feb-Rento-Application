package genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest implements FrameworkConstants {
	public DataUtility data_Utility = new DataUtility();
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORTS_PATH+JavaUtility.getTimeStamp()+".html");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
	}

	@Parameters("browserName")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {

		if (browserName.equals("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary(CHROME_EXE_PATH);
			driver = new ChromeDriver(opt);
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownReport() {
		report.flush();
	}

}
