package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	
	public LogoutPage (WebDriver driver) {
		super(driver);
	}
	
	/*@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;*/
	
	@FindBy(xpath="//div[@class='nav float-end']//a[@class='dropdown-toggle']")
	WebElement Dropdown;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement Logoutdropdown;
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement AccLogoutmsg;
	
	
	public void scrolltologout() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement scrollto = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
		js.executeScript("arguments[0].click();", scrollto);
	}
	
	/*public void Logoutbtn() {
		Logout.click();
	}*/
	
	public void dropdown() {
		Dropdown.click();
	}
	
	public void Logoutddwn() {
		Logoutdropdown.click();
	}
	
	public String AccLogout() {
		try {
			return (AccLogoutmsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}

}
