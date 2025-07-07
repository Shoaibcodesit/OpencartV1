package testcases;

import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import org.testng.Assert;
import testbase.BaseClass;

public class TS_002_LoginFunctionality extends BaseClass {
	
	@Test
	public void verify_login() {
		logger.info("******     STARTING TS_002_LOGIN TEST     *******");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.LoginTo();
		
		//My Account Page
		MyAccountPage acc = new MyAccountPage(driver);
		boolean targetpage = acc.isMyAccountPageExists();
		
		Assert.assertTrue(targetpage);
	}
	catch(Exception e) {
		Assert.fail();
	}
	
}
}
