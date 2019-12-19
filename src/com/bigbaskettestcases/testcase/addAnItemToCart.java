package com.bigbaskettestcases.testcase;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.bigbasketbase.page.BasePage;

public class addAnItemToCart extends BasePage {
	
	
	
	public addAnItemToCart() throws IOException {
		super();
	}

	@Test
	  public void tc1() {
		  
	      elementClick("Beauty&Grooming");
	      elementClick("LakmeNailRemover");
	      elementClick("AddToCart");
		  try {
			  driver.findElement(By.xpath(OR.getProperty("1Item")));
			  System.out.println("Product is added to cart and item quantity is one");
		    } catch (NoSuchElementException e) {
		    	System.out.println("Product is not added to cart");
		    }
		    
	
	      driver.close();
	}
}

