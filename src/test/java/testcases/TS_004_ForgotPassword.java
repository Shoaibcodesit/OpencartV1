package testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.ForgotPassword;
import pageobjects.HomePage;
import testbase.BaseClass;

public class TS_004_ForgotPassword extends BaseClass{
	@Test
	public void forgot_password_validEmail() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		ForgotPassword fp = new ForgotPassword(driver);
		fp.Forgotpassword();
		//fp.Email(randomString() + "@gmail.com");
		fp.Email(p.getProperty("email"));
		fp.btnContinue();
		
		try {
			WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            String actualsuccessMsg = successMsg.getText().trim();
            String expectedsuccessMsg = "Success: Your password has been successfully updated.";

            Assert.assertTrue(actualsuccessMsg.contains(expectedsuccessMsg), "Test Failed expected success message not displayed." + actualsuccessMsg);
            System.out.println("Test Passed: Password updated successfully for valid email.");
        } 
		catch (TimeoutException e) 
		{ 
        	Assert.fail("Test failed: " + e.getMessage());
	    }
	}
	
	@Test
	public void forgot_password_invalidEmail() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		ForgotPassword fp = new ForgotPassword(driver);
		fp.Forgotpassword();
		//fp.Email(p.getProperty("email"));
		fp.Email(randomString() + "@gmail.com");
		fp.btnContinue();
		try {
	        // Disable CSS transitions/animations before triggering
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	            "var style = document.createElement('style');" +
	            "style.innerHTML = '.alert-danger { transition: none !important; animation: none !important; opacity: 1 !important; }';" +
	            "document.head.appendChild(style);"
	        );
	        
	        // Now try to capture with normal wait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement warningMsg = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//div[contains(@class,'alert-danger')]")));
	        
	        String actualMsg = warningMsg.getText().trim();
	        String expectedMsg = "Warning: The E-Mail Address was not found in our records!";
	        
	        Assert.assertTrue(actualMsg.contains(expectedMsg), 
	            "Test Failed: Expected warning not displayed. Actual: " + actualMsg);
	        System.out.println("Warning captured after disabling animation: " + actualMsg);
	        
	    } catch (Exception ex) {
	        Assert.fail("Test failed: " + ex.getMessage());
	    }
	}
}