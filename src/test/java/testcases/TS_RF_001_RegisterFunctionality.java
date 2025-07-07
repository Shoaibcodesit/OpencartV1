package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.RegisterFunctionality;
import testbase.BaseClass;

public class TS_RF_001_RegisterFunctionality extends BaseClass {
	
	@Test
	public void verify_register_functionality() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		logger.info("***** STARTS THE EXECUTION OF THE TEST CASE *****");
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegisterFunctionality rf = new RegisterFunctionality(driver);
		logger.info("***** ENTERS THE DETAILS OF THE CUSTOMER *****");
		rf.setFirstname(randomString().toUpperCase());
		rf.setLastname(randomString().toUpperCase());
		rf.setEmail(randomString() + "@gmail.com");
		rf.setPassword(randomAlphanumeric());
		rf.scrolldown();
		Thread.sleep(5000);
		rf.setPrivacypolicy();
		rf.clickContinue();
		logger.info("***** DETAILS ENTERED IN THE FORM *****");
		
		String confirmmsg = rf.getConfirmationmsg();
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		logger.info("**** ACCOUNT CREATED SUCCESSFULLY, ENDS THE EXECUTION OF THE TEST CASE *****");
	}

}
