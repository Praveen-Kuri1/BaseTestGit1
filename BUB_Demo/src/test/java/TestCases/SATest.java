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

public class SATest extends BaseTest {
	
	
		@Test
		public void SALogin() throws IOException
		{
			LandingPO landingPO=launchApplication();
			landingPO.LoginCredential("sa@user.com", "123");
			System.out.println("SA Login Success");
		}
}
