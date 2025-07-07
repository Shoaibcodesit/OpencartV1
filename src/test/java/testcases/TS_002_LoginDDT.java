package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TS_002_LoginDDT extends BaseClass {
	
	@Test(dataProvider ="LoginData" , dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String res) 
	{
		logger.info("************  Starting the logint DDT   ******************");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.LoginTo();
		
		//My Account Page
		MyAccountPage acc = new MyAccountPage(driver);
		boolean targetpage = acc.isMyAccountPageExists();
		
		
		if(res.equalsIgnoreCase("Valid")) {
			if(targetpage == true) {
				Assert.assertTrue(true);
				acc.ScrollToLogout();	
				acc.Logoutbtn();
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid")) {
			if(targetpage == true) {
				acc.Logoutbtn();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*************  Login DDT completed   ****************");
	}

}
