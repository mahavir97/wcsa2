package generic;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonLib extends BaseTest
{
	//verify page title
	public void verifyPageTitle(String expectedTitle,String pageName)
	{
		  String actualTitle = driver.getTitle();
		  if(actualTitle.equals(expectedTitle))
		  {
		   System.out.println("The title is matched for"+pageName);
	}
		  else
	{
		System.out.println("The title is notmatched for"+pageName);
	}
	}

	//get title of webpage
	public String getTitleOfWebPage(String pageName)
	{
		      String TitleOfWebPage = driver.getTitle();
		      return TitleOfWebPage;
	}
	
	//frame handling and its method overloading
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	public void switchToFrame(WebElement frameelement )
	{
		driver.switchTo().frame(frameelement);
	}
	
	//maximize the browser using method chaining
	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
	//dropdown
	public void selectOptionOfDropdown(WebElement element,int index)
	{
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	public void selectOptionOfDropdown(WebElement element,String value)
	{
		Select sel =new Select(element);
		sel.selectByValue(value);
	}
	public void selectOptionOfDropdown(String visibletext,WebElement element)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(visibletext);
	}
	//pop-up
	public void acceptAlertPopup()
	{
		 Alert a1 = driver.switchTo().alert();
		 a1.accept();
	}
	public void acceptConfirmationPopup()
	{
		   Alert a1 = driver.switchTo().alert();
		   a1.accept();
	}
	public void dismissConfirmationPopup()
	{
		   Alert a1 = driver.switchTo().alert();
		   a1.dismiss();
	}
	
	//actions class
	public void rightClick(WebElement target)
	{
	  Actions act = new Actions(driver);
	  act.contextClick(target).perform();
	}
	public void doubleClick(WebElement target)
	{
	  Actions act = new Actions(driver);
	  act.doubleClick(target).perform();
	}
	public void mouseHover(WebElement target)
	{
	  Actions act = new Actions(driver);
	  act.moveToElement(target).perform();
	}
	public void dragAndDrop(WebElement source,WebElement destination)
	{
	  Actions act = new Actions(driver);
	  act.dragAndDrop(source,destination).perform();
	}
	//Robot class
	public void hitTheEnterButton() throws AWTException
	{
	   Robot robot = new Robot();
	   robot.keyPress(KeyEvent.VK_ENTER);
	   robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void copyTheText() throws AWTException
	{
	   Robot robot = new Robot();
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_C);
	   robot.keyRelease(KeyEvent.VK_C);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
    }
	public void pasteTheText() throws AWTException
	{
	   Robot robot = new Robot();
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
    }
	//scrolling operation
	public void scrollDown(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixelCount+")");
	}
	public void scrollUp(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixelCount)+")");
	}
	public void scrollLeft(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(-pixelCount)+",0)");
	}
	public void scrollRight(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixelCount+",0)");
	}
	public void ScrollTillParticularWebElement(WebElement target)
	{
		    Point loc = target.getLocation();
	     	  int xaxis = loc.getX();
	     	  int yaxis =loc.getY();
	     	JavascriptExecutor jse = (JavascriptExecutor)driver;
	     	jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}
	
	//getAllOptions
	public void getAllOptionsOfDropdown(WebElement element)
	{
		      Select sel = new Select(element);
		   List<WebElement> allops = sel.getAllSelectedOptions();
		   for(WebElement op:allops)
		   {
			   String text = op.getText();
			   System.out.println(text);
			   
		   }
	}
	
	

	

	

	
	}
	

