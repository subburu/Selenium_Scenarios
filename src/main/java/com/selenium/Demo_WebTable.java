package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_WebTable {

	@Test
	public void verifyTable () throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver ();
		driver.get("https://seleniumpractise.blogspot.com/");
		driver.manage().window().maximize();
		// Returns List of elements 
	 List <WebElement> allHeaders =	driver.findElements(By.xpath("//table[contains(@id,'cust')]//th"));
		System.out.println(allHeaders.size());
	
		Assert.assertEquals(allHeaders.size(), 5,"Columns matched");
		boolean status =false;
		
		for (WebElement ele : allHeaders)
		{
			String value =ele.getText();
			System.out.println(value);
			if (value.contains("Country"))
			{
				status= true;
				break;
			}
			
		}
		
		Assert.assertTrue(status,"Header is  present");
		System.out.println("====================");
		// No of Rows 
		
	List <WebElement> noofrows=	driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr"));
	System.out.println("Total number of rows "+ noofrows.size());    
    Assert.assertEquals(noofrows.size(),7,"Table row count mismatched");
    
	System.out.println("====================");
	
	// getting table data 
	
 List <WebElement> alldata =	driver.findElements(By.xpath("//table[contains(@id,'cust')]//td"));
	
 // verify ola -- particular value is present or not 
 
 boolean dataStatus =false;
 for (WebElement ele : alldata)
 {
	 String value = ele.getText();
	 System.out.println(value);
	 if (value.contains("Ola"))
	 {
		 dataStatus=true;
		 break;
	 }
 }
	
		Assert.assertTrue(dataStatus,"Record did not find");
		
		
		   
		System.out.println("====================");
		
		// getting table data 
		
	 List <WebElement> companyNames =	driver.findElements(By.xpath("//table[contains(@id,'cust')]//td[2]"));
		
	 // verify ola -- particular value is present or not 
	 
	 boolean companyStatus =false;
	 for (WebElement ele : alldata)
	 {
		 String value = ele.getText();
		 System.out.println(value);
		 if (value.contains("Java"))
		 {
			 companyStatus=true;
			 break;
		 }
	 }
	 
	 for (int i=0;i<companyNames.size();i++)
	 {
		 WebElement element =companyNames.get(i);
		String value = element.getText();
		 if (value.contains("Java"))
		 {
			 companyStatus=true;

		 }
	 }
		
	 driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//td[text()='Selenium']/following-sibling::td[3]//a")).click();
	 
	Assert.assertTrue(companyStatus,"Value did not find");
			
		
		
		
		
		
		
		
		driver.quit();
	
		
		
		
	}

}
