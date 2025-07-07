package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterFunctionality extends BasePage{
	
	public RegisterFunctionality(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement Newslettercheckbox;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Agreecheckbox;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Msgconfirmation;
	
	//Actions
	
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubscribe() {
		Newslettercheckbox.click();
	}
	
	public void setPrivacypolicy() {
		Agreecheckbox.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void scrolldown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        js.executeScript("arguments[0].scrollIntoView()", scroll);
}
	
	public String getConfirmationmsg() {
		try {
			return (Msgconfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}

}
