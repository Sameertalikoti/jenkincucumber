package Stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDef {
	
	 WebDriver driver;
	LoginPage loginpage;
	
	@Given("User Launch Chrome Broswer")
	public void user_launch_chrome_broswer() {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver=new ChromeDriver();
		
		loginpage= new LoginPage(driver);
	   
	}

	@When("user Opens URL {string}")
	public void user_opens_url(String URL) {
		
	   driver.get(URL);
	  
	}

	@When("User enters Email {string} and Password {string}")
	public void user_enters_email_admin_yourstore_com_and_password_admin(String emaladdress, String Passwords) {
		loginpage.enterEmail(emaladdress);
		loginpage.enterPassword(Passwords);
	    
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	   loginpage.enterLoginbutton();
	}

	
	@Then("Page title should be {string}")
	public void page_title_should_be(String expected) {
		
		String ActualResult=driver.getTitle();
		
		if(ActualResult.equals(expected))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	   
	}

	/*
	 * @When("User click on Logout button") public void
	 * user_click_on_logout_button() { loginpage.enterLogoutbutton(); }
	 */	

	@Then("Close Browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	   
	}
	
	@After
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			String Savefile = "C://Users//ThinkPad//eclipse-workspace//Cucumberframework//Screenshot/image.png";
			TakesScreenshot file= ((TakesScreenshot)driver);
			
			File scrimage=file.getScreenshotAs(OutputType.FILE);
			
			File outimage=new File(Savefile);
			
		   FileUtils.copyFile(scrimage, outimage);
			
			
		}
		System.out.println("Closing the window with hooks method");
		
		
		driver.quit();
		
	}


}
