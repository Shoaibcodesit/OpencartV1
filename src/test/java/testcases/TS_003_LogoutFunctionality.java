package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import testbase.BaseClass;

public class TS_003_LogoutFunctionality extends BaseClass{
	
	@Test
	public void verify_logout_functionality () throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.LoginTo();
		
		Thread.sleep(2000);
		LogoutPage lo = new LogoutPage(driver);
		//lo.scrolltologout();
		//lo.Logoutbtn();
		lo.dropdown();
		lo.Logoutddwn();
		
		
		String logoutmsg = lo.AccLogout();
		Assert.assertEquals(logoutmsg, "Account Logout");
	}
	

}
