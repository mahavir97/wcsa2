package generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class BaseTest implements IAutoConstant {

	static WebDriver driver;
	@Test
	public void setup() throws IOException//to open the browser
	{
		Flib flib = new Flib();

		//read the browser value
		String browservalue = flib.readPropertFile(PROP_PATH,"browser");
		//read the url 
		String url = flib.readPropertFile(PROP_PATH, "url");
		if(browservalue.equalsIgnoreCase("chrome"))
		{
			{
				System.setProperty(CHROME_KEY,CHROME_VALUE);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.get(url);
			}
		}
		

		else if(browservalue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY,GECKO_VALUE);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);

		}
		else
		{
			Reporter.log("Invalid Choice",true);
		}

	}


	//close all the browsers
	public void closeBrowser()
	{
		driver.quit();
	}


}