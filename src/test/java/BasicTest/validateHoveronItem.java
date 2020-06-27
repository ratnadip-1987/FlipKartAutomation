package BasicTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.TestBase;
import commonUtils.testUtils;
import pageObject.ProductdetailsPage;
import pageObject.homePage;
import pageObject.searchResultPage;

public class validateHoveronItem extends TestBase {
	
	testUtils commonUtls = new testUtils();
	public validateHoveronItem()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initilize();
		  
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
	public void validateSearchItemPage()
	{
	   boolean bFlag=false;
	   commonUtls.waitForElementToClickable(driver,homePage.Home_searchBox, 20);
	   driver.findElement(homePage.Home_searchBox).sendKeys("shirt");
	   driver.findElement(homePage.Home_searchBox).sendKeys(Keys.ENTER);
	   if(driver.findElement(searchResultPage.srp_header).getText().contains("shirt"))
	   {
		   bFlag=true;
		   System.out.println("search page is reached");		   
	   }      
	   Assert.assertEquals(true, bFlag,"not navigated to search page");
		   	
	}
	
	@Test(priority=3)
	public void validateuserNavigatedToPDP() throws InterruptedException
	{
	   boolean bFlag=false;
//	   boolean bFlag1=false;
//	   boolean bFlag2=false;
	   commonUtls.waitForElementToClickable(driver,searchResultPage.product_list, 20);
	   List<WebElement> liobj=driver.findElements(searchResultPage.product_list);
	   if(liobj.size()>0)
	   {
		   System.out.println("page has some product to display");
		   liobj.get(0).click();
		   
		   Set<String> handle=driver.getWindowHandles();
		   Iterator<String> it=handle.iterator();
		   String parentWindowID= it.next();
		   System.out.println("parent window Id---"+parentWindowID);
		   String childWindowID= it.next();
		   System.out.println("child window Id---"+childWindowID); 
		   driver.switchTo().window(childWindowID);
		   
		   if(driver.findElement(ProductdetailsPage.prodImage).isDisplayed())
		   {
			   bFlag=true;
			   System.out.println("User is on PDP");
		   }
		   
		   commonUtls.mouseHoverElement(driver.findElement(ProductdetailsPage.prodImage));
		   Thread.sleep(4000);	
		   commonUtls.mouseHoverElement(driver.findElement(ProductdetailsPage.prodImage));
		   Thread.sleep(4000);	
	   }
	   
	   Assert.assertEquals(true, bFlag,"not navigated to PDP");
		   	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	
	

}
