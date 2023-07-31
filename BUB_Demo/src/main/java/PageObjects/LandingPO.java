package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPO {
	WebDriver driver;
	public LandingPO (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath ="//button[.=' Sign in ']")
	WebElement signin;
	
	public void LoginCredential(String email, String password) 
	{
		Email.sendKeys(email);
		Password.sendKeys(password);
		signin.click();
		
	}
	
	public void GoToPage()
	{
		driver.get("https://uatbilling.boycecloud.com/BUBWeb_New/index.html#/auth/login");
	}
	
	
}
