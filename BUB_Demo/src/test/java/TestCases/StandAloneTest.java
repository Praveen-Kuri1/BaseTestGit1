package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import PageObjects.LandingPO;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {
	
	
		@Test
		public void BALogin() throws IOException
		{
			Land.LoginCredential("ba@user.com", "123");
			System.out.println("BA Login Success");
		}
		
		
		@Test
		public void TitleTest()
		{
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "Boyce Utility Billing - NT";
			if(ActualTitle.equalsIgnoreCase(ExpectedTitle))
				System.out.println("Title Matched");
			else
				System.out.println("Title didn't match");
		}
}
