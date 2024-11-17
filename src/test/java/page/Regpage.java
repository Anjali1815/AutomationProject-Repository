package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Regpage {
	
	WebDriver driver;
	
	By Regname=By.id("name");
	
	By Regemail=By.name("email");
	By Regpassword=By.id("password");
	
	By Regmobile=By.id("mobile");
	
	By Regfresher=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[4]/div[2]/div[2]/div[2]/p");
	
	By Selectcity=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[5]/div/div[2]/div/div[3]/span[1]");
	By Register=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[7]/button");
	
	
	public  Regpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setvalues(String name,String email,String password,String mobile)
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(Regname).sendKeys(name);
		driver.findElement(Regemail).sendKeys(email);
		driver.findElement(Regpassword).sendKeys(password);
		driver.findElement(Regmobile).sendKeys(mobile);
		driver.findElement(Regfresher).click();
		driver.findElement(Selectcity).click();
		
	
		
		
	}
	
	
	public void register()
	{
		
		
		driver.findElement(Register).click();
	}

}
