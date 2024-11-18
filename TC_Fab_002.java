package testScript.Wardrobe;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.BedRoom;
import elementRepository.HomePage;
import genericLibrary.BaseTest;
import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class TC_Fab_002 extends BaseTest {
	@Test
	public void Verify_user_is_able_to_click_on_wardrobe_option() throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Create a test in the report 
		test = report.createTest("Verify user is able to click on wardrobe option");
		
		// Initialize HomePage object to access home page elements
        HomePage page = new HomePage(driver);

        // Validate successful navigation to the Home Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Initialize BedRoom page object to access wardrobe elements
        BedRoom wardrobe = new BedRoom(driver);
 
        // Scroll down to the wardrobe element
        WebDriverUtility driverUtility = new WebDriverUtility();
        driverUtility.actionsScrollTillElement(driver, wardrobe.getWardrobePage());

        // Click on the wardrobe option
        wardrobe.getWardrobePage().click();

        // Validate that the Wardrobe page is displayed
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 3, 1));
        Reporter.log("Wardrobe page is displayed", true);
        test.log(Status.PASS, "Wardrobe page is displayed");

        // Capture a screenshot of the Wardrobe page for the report
        test.addScreenCaptureFromBase64String(driverUtility.captureScreenshotForReport(driver));

		 
	}

}
