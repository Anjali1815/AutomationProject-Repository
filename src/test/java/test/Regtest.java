package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Regpage;



public class Regtest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
	}
	
	@Test
	public void regtest()
	{
		
	
		Regpage ob=new Regpage(driver);
		ob.setvalues("Anjali", "testingsite123@gmail.com", "Naukri@123","9447411815");
		ob.register();
	}
	
	

}
