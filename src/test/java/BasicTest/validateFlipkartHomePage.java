package BasicTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.TestBase;
import commonUtils.testUtils;
import pageObject.homePage;

public class validateFlipkartHomePage extends TestBase {
	
	
	public validateFlipkartHomePage()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initilize();
		testUtils commonUtls = new testUtils();
		if(driver.getTitle().contains("Shopping"))
		{
			System.out.println("Url launched sucessfully");  
		}	
			
	}
	
	@Test(priority=1)
	public void validateLightBox()
	{
	   boolean bFlag=false;
	   if(driver.findElement(homePage.Home_lightBoxmodal_closebutton).isDisplayed())
	   {
		  System.out.println("light Box modal displayed");  
		  driver.findElement(homePage.Home_lightBoxmodal_closebutton).click();
		  bFlag=true;
	   }	   
	   Assert.assertEquals(true, bFlag,"light box is not displayed");
		   	
	}
	
	@Test(priority=2)
	public void validateTitle()
	{
	   boolean bFlag=false;
	   if(driver.getTitle().contains("Online Shopping Site"));
	   {
		   System.out.println("title is validated sucessfully"); 
		   bFlag=true;
	   }
	   Assert.assertEquals(true, bFlag,"title is not matched");
		   	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	
	

}
