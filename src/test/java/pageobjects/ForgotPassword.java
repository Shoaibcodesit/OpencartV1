package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage{
	
	public ForgotPassword(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='mb-3']//a[normalize-space()='Forgotten Password']")
	WebElement Forgotpass;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Input_email;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continuebtn;
	
	public void Forgotpassword() {
		Forgotpass.click();
	}
	
	public void Email(String email) {
		Input_email.sendKeys(email);
	}
	
	public void btnContinue() {
		continuebtn.click();
	}

}
