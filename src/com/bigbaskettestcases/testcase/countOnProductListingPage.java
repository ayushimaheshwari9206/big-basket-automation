package com.bigbaskettestcases.testcase;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bigbasketbase.page.BasePage;


public class countOnProductListingPage extends BasePage {
	
	 public countOnProductListingPage() throws IOException {
		super();
	}

	@Test
	  public void tc2() throws InterruptedException
	  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  elementClick("Category");
	  driver.findElement(By.linkText("Fruits & Vegetables")).click();
	  WebElement count = driver.findElement(By.id("snowplow_screen_view_totalcount"));
	  System.out.println("Number of products:- "+ count.getAttribute("value"));
	  
	  try {
		    long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

		    while (true) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(5000);

		        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		        if (newHeight == lastHeight) {
		            break;
		        }
		        lastHeight = newHeight;
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	  js.executeScript("window.scrollBy(0,-1500)");
	  
	  
	  for(int i=1; i<=16; i++)
	  {
		  elementClick(OR.getProperty("ShowMore"));
	  }
	  
	  driver.close();
	  
	  }  

}
