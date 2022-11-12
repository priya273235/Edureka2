package com.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LambdaCertification {
	WebDriver driver;
	@BeforeMethod
	public void Launch() {

	
		System.setProperty("webdriver.chrome.driver",
				"D:\\New folder\\SelIntroduction\\ChromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();

	}
	@Test
	public void Scenario1() {
		String Message = "Welcome to Lambda test";
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();
		System.out.println("clicked");
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(Message);
		System.out.println("Message entered successfully");
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		System.out.println("Clicked on checked button");
		String a=driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertEquals(Message, a);
		System.out.println("Both are same:)");
		
	}
	public void Scenario2(){
		
		
	}

}

