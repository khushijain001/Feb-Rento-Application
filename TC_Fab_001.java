package testScript.Wardrobe;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.HomePage;
import genericLibrary.BaseTest;
import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class TC_Fab_001 extends BaseTest{
	
	@Test
	public  void Verify_user_is_able_to_click_on_bedroom_option() throws EncryptedDocumentException, IOException {
		
		// Create a test in the report 
		test = report.createTest("Verify user is able to click on bedroom option");
		
		// Initialize HomePage object
        HomePage page = new HomePage(driver);

        // Validate that the user navigated to the Home Page successfully
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Click on the 'Bedroom' option on the homepage
        page.getBedroomPage().click();

        // Validate that the user is able to access the Bedroom Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 2, 1));
        Reporter.log("Bedroom page is displayed", true);
        test.log(Status.PASS, "Bedroom page is displayed");

        // Capture a screenshot after navigating to the Bedroom Page
        WebDriverUtility driver_Utility = new WebDriverUtility();
        test.addScreenCaptureFromBase64String(driver_Utility.captureScreenshotForReport(driver));
  
	
	    
		}
}
