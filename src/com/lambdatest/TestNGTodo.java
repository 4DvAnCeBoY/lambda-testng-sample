package com.lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGTodo {
	
	private RemoteWebDriver driver;
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
		String username = "asad360logica";
		String authkey = "4b140c78-2f70-4e2b-a733-e556e02ecde9";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "Chrome");	// Automatically pulls the latest version of Chrome
		caps.setCapability("platform", "Windows 10");	// To specify a version, add setCapability("version", "desired version")
		
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey	+ "@ondemand.saucelabs.com:443/wd/hub"), caps);
	}
	
	@Test
	public void basicTest() {
		System.out.println("Loading Url");
                driver.get("https://4dvanceboy.github.io/lambdatest/todo.html");

                
                System.out.println("Checking Box");
                driver.findElement(By.name("todo-4")).click();

                System.out.println("Checking Another Box");
                driver.findElement(By.name("todo-5")).click();
                
                // If both clicks worked, then the following List should be have length 2
                List<WebElement> elems = driver.findElements(By.className("done-true"));
                // So we'll assert that this is correct.
                Assert.assertEquals(2, elems.size());
                
                System.out.println("Entering Text");
                driver.findElement(By.id("todotext")).sendKeys("Get Taste of Lambda and Stick to It");
                driver.findElement(By.id("addbutton")).click();
                
                // Let's also assert that the todo we added is present in the list.
                String spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[6]/span").getText();
                Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);       
                
                System.out.println("Taking Snapshot");
                System.out.println("TestFinished");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}