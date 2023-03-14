package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenElements {
	
	/*
	 * By default we cannot handle hidden elements Exceptions 
	 * Element not visible
	 * ElementNotInteractableException
	 * Using JavaScript Executor we can handle the hidden elements
	 * document.getElementById('displayed-text') -- in console
	 * 
	 */

	
	public static void main (String args [])
	{
		
	//	ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
	      driver.get("https://courses.letskodeit.com/practice");
	      driver.findElement(By.id("hide-textbox")).click();  // hide button clicked
	//      driver.findElement(By.id("displayed-text")).sendKeys("Sravan");
	      // identify text
	      JavascriptExecutor jse =(JavascriptExecutor) driver;
	      jse.executeScript("document.getElementById('displayed-text').value='Sravan Testing';");
	
	
}
}