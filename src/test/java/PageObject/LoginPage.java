package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
 @FindBy(id="Email")
 WebElement email;
 
 @FindBy(id="Password")
 WebElement password;
 
 @FindBy(xpath = "//button[@Class='button-1 login-button']")
 WebElement login;
 
 @FindBy(linkText="Logout")
 WebElement Logout;
 
 public void enterEmail(String emailaddress)
 {
	 email.clear();
	 email.sendKeys(emailaddress);
 }
 
 public void enterPassword(String epassword)
 {
	 password.clear();
	 password.sendKeys(epassword);
 }
 
 public void enterLoginbutton()
 {
	 login.click();
 }
 
	/*
	 * public void enterLogoutbutton() { Logout.click(); }
	 */
}
