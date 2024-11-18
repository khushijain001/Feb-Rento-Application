package testScript.Wardrobe;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.HomePage;
import genericLibrary.BaseTest;

public class Login extends BaseTest {
	@Test
	public void loginCredential() throws IOException, InterruptedException  {
		
		// Create a test in the report for logging purposes
		test = report.createTest("Display Wardrobe");
		
		// Initialize HomePage object
        HomePage home = new HomePage(driver);

        // Navigate to login page
        home.getLoginPage().click();

        // Validate if the current URL matches the expected URL from properties
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromProperties("url"));
        test.log(Status.PASS, "Home Page displayed and login button clicked");
        Reporter.log("Clicked Login successfully", true);

        // Enter login credentials
        home.getEnterEmail().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 0));
        home.getEnterPassword().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 1));
        
        // Submit login form
        home.getClickOnSubmit().click();

        // Wait for 3 seconds to ensure the page loads after login
        Thread.sleep(3000);
		
		
	}

}
