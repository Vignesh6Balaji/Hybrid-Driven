package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

@SuppressWarnings("deprecation")
public class Steps {
	
	public WebDriver driver;
	public LoginPage lpage;
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
	    lpage=new LoginPage(driver);
	}
	
	@When("User open URL {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}
	
	@When("User Enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String user, String pass) throws InterruptedException {
	    lpage.setUserName(user);
	    lpage.setPassword(pass);
	}
	
	@When("Click on Login")
	public void click_on_login() {
	    lpage.clickLogin();
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Invalid credentials")) {
	    	driver.quit();
	    	Assert.assertTrue(false);
	    }
	    else {
	    	Assert.assertEquals(title, driver.getCurrentUrl());
	    }
	}
	
	@When("User Click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    lpage.clickProfile();
	    lpage.clickLogout();
	    Thread.sleep(3000);
	}
	
	@Then("Close Browser")
	public void close_browser() {
	    driver.quit();
	}
}
