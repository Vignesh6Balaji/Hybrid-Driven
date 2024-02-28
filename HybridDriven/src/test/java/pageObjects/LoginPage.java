package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver adriver) {
		driver = adriver;
		PageFactory.initElements(adriver, this);
		
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement login;
	
	@FindBy(className = "oxd-userdropdown-name")
	@CacheLookup
	WebElement profile;
	
	@FindBy(xpath = "//a[text()='Logout']")
	@CacheLookup
	WebElement logout;
	
	public void setUserName(String username) throws InterruptedException {
		Thread.sleep(3000);
		userName.clear();
		userName.sendKeys(username);
	}
	
	public void setPassword(String passWord) {
		password.clear();
		password.sendKeys(passWord);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickProfile() throws InterruptedException {
		Thread.sleep(3000);
		profile.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}

