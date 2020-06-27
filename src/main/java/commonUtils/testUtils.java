package commonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.TestBase;

public class testUtils extends TestBase {
	
   public void mouseHoverElement(WebElement element)
   {
	  Actions action=new Actions(driver);
	  action.moveToElement(element).perform();
   }
   
   public void dropDownElement(WebElement element, String text)
   {
	   Select select=new Select(element); 
	   select.selectByVisibleText(text);
   }
   
    
   public void waitForElementToClickable(WebDriver driver,By element, int ts)
   {
     WebDriverWait wait=new WebDriverWait(driver,ts);
     System.out.println("waiting for element to clickable");
   //  wait.until(ExpectedConditions.elementToBeClickable(element));
     wait.until(ExpectedConditions.presenceOfElementLocated(element));
   }
   
}


