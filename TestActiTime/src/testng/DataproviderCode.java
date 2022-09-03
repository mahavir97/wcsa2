package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataproviderCode {
	WebDriver driver;
	
	@Test(dataProvider ="dp")
	public void testActiTimeValidLogin(String invalidusername,String invalidpassword) 
	{
		driver.findElement(By.name("username")).sendKeys(invalidusername);
		driver.findElement(By.name("pwd")).sendKeys(invalidpassword);
		driver.findElement(By.id("loginButton")).click();
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://127.0.0.1/login.dojsessionid=v61u928nexsu");

	}

	@AfterMethod
	public void afterMethod() 
	{

		driver.quit();
		
	}

	@DataProvider
	public Object[][] dp() 
	{
		Object[][]data=new Object[5][2];
		
		data[0][0]="admin";
		data[0][1]="manager123";
		
		data[1][0]="manager";
		data[1][1]="manager123";
		
		data[2][0]="ad13";
		data[2][1]="manager123";
		
		data[3][0]="admin#123";
		data[3][1]="manager123";
		
		data[4][0]="manager1@133";
		data[4][1]="manager123";
		
		
		return data;
		
		}
	}