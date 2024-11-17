package page;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Loginpage {
	
	WebDriver driver;
	
	
	
	By Naukriemail=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input");
	
	By Naukripassword=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input");
	By Naukrilogin=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button");
	//By jobs=By.xpath("/html/body/div[3]/div[2]/nav/ul/li[1]/a/div");
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void setvalues(String email,String password)
	{
		driver.findElement(Naukriemail).clear();
		driver.findElement(Naukriemail).sendKeys(email);
		driver.findElement(Naukripassword).clear();
		driver.findElement(Naukripassword).sendKeys(password);
	
    }
	
	public void login()
	{
		driver.findElement(Naukrilogin).click();
	}
	
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
		System.out.println("actual title is:"+actualtitle);
		
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
	

	
	public void completeprofile()
	{
		List<WebElement> profile =  driver.findElements(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a"));
		
		for(WebElement ele:profile)
		{
			String text=ele.getText();
		
			if(text.equals("Complete profile"))
			{
				ele.click();
				driver.navigate().back();
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)", "");
		
		List<WebElement> privacy = driver.findElements(By.xpath("/html/body/footer/section[1]/div/div/div[4]/ul/li[1]/a"));
		for(WebElement ele1:privacy)
		{
			ele1.click();
			driver.navigate().back();
		}
		
		}
	
	public void screenshot() throws IOException
	
	{
		try
		{

        
	   WebElement naukri = driver.findElement(By.xpath("/html/body/div[3]/div[2]/a/img"));
		
	
		
		File src=naukri.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/naukriscreenshot.png"));
		}

		catch (Exception e)
		{
	        System.out.println("An error occurred: " + e.getMessage());
	    }
		}
	
  	public void windowhandling()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window Title  "+driver.getTitle());
		List<WebElement> customerservice = driver.findElements(By.xpath("/html/body/main/div/div/div[4]/div/div[3]/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div[2]/a"));
		for(WebElement ele:customerservice)
          {
	          ele.click();
           }
		Set<String> allwindowhandles = driver.getWindowHandles();
		
		for(String handle:allwindowhandles)
		{
			System.out.println(handle);
			
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
			
				List<WebElement> save = driver.findElements(By.xpath("//*[@id=\"job_header\"]/div[2]/div[2]/button[1]"));
				   for(WebElement ele:save)
				   {
					   ele.click();
				   }
				driver.close();
				
			}
			
			driver.switchTo().window(parentWindow);
		}
	
	}  
  	
  	
	
	}
	
	
	
	
	
	
	
	
	
	
	 
	
	
	


