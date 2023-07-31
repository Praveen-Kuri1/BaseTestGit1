package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPO Land;
	
	public WebDriver initializeDrivers() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String BrowserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		prop.getProperty("browser");
		
		if (BrowserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver =new ChromeDriver(options);
			//driver.manage().window().maximize();
			//driver.manage().window().setSize(new Dimension(1440, 900)); For full screen visibility in headless mode. 
		}
		else if (BrowserName.equalsIgnoreCase("edge")) 
		{
			driver =new EdgeDriver();	
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty(("user.dir")+"//Reports//"+testCaseName+".png"));
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
	}
	 
	@BeforeMethod(alwaysRun=true)
	public  LandingPO launchApplication() throws IOException
	{
		driver = initializeDrivers();
		Land =new LandingPO(driver);
		Land.GoToPage();
		return Land;	 
	}
	
	@AfterMethod(alwaysRun=true)
	public void TearDown()
	{
		driver.close();
	}
}
