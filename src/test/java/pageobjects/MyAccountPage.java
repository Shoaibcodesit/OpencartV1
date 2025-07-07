package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;
	
	public boolean isMyAccountPageExists() {
		try 
		{
			return (MyAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void ScrollToLogout() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement scroll = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
		js.executeScript("arguments[0].scrollIntoView()", scroll);
	}
	
	public void Logoutbtn() {
		Logout.click();
	}

}
