package test;






import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Baseclass;
import page.Loginpage;
import utilities.Excelutil;

public class Logintest extends Baseclass
{
	
	
	@Test
	public void verifylogin() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"login_Layer\"]")).click();	
		
		
		Loginpage p1=new Loginpage(driver);
		
		String xl="E:\\projectdatadriven.xlsx";
		String sheet="Sheet1";
		
		int rawcount=Excelutil.getRowCount(xl,sheet);
		for(int i=1;i<=rawcount;i++)
		{
			String username=Excelutil.getCellValues(xl,sheet,i,0);
			
			System.out.println("username--"+username);
			
			String pwd=Excelutil.getCellValues(xl,sheet,i,1);
			System.out.println("password---"+pwd);
			p1.setvalues(username,pwd);
			p1.login();
			p1.titleverification();
	        p1.completeprofile();
	        p1.screenshot();
	        p1.windowhandling();
	        
	        			
			}
		
		
		
		}
	
	
	}
