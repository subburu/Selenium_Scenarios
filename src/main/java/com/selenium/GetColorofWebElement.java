package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetColorofWebElement {
	
	public static void main (String args [])
	{
		

		WebDriverManager.chromedriver().setup();
		   WebDriver driver = new ChromeDriver();
	      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // identify text
	      WebElement t = driver.findElement(By.xpath("//div[@class='navbar-nav d-lg-inline-block nav-login']"));
	      //obtain color in rgba
	      String s1 = t.getCssValue("background-color"); 
	      String s = t.getCssValue("color");
	      // convert rgba to hex
	      String c = Color.fromString(s).asHex();
	      System.out.println("Color is :" + s);
	      String c1 = Color.fromString(s1).asHex();
	      System.out.println("Back Ground color is : " + s1);
	      System.out.println("Hex code for color:" + c);
	      System.out.println("Back Ground color is : " + s1);
	      System.out.println("Back Ground color is : " + c1);
	      driver.quit();
	      
	}

}
