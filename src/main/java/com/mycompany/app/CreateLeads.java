package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeads {

	WebDriver driver;
	@Test
	public void testCreateLeads()
	{
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		select.selectByValue("Ms.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("jas");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("bhu");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("cognizant");
		 WebElement LeadSource = driver.findElement(By.xpath("//select[@name='leadsource']"));
		 select = new Select(LeadSource);
		 select.selectByIndex(3);
		 WebElement Industry = driver.findElement(By.name("industry"));
		 select = new Select(Industry);
		 select.selectByVisibleText("Apparel");
		 driver.findElement(By.name("annualrevenue")).sendKeys("20000");
		 driver.findElement(By.name("noofemployees")).sendKeys("2");
		 driver.findElement(By.name("secondaryemail")).sendKeys("jas@jas.com");
		 driver.findElement(By.xpath("//textarea[@name='lane']")).sendKeys("nager bazar");
		 driver.findElement(By.xpath("//input[@name='code']")).sendKeys("789456");
		 driver.findElement(By.xpath("//input[@name='country']")).sendKeys("india");
		 driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("test...");
		 
		 driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("4561230");
		 driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("1230456789");
		 driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jas@asb.com");
		 WebElement Leadstatus = driver.findElement(By.name("leadstatus"));
		 select = new Select(Leadstatus);
		 select.selectByVisibleText("Contact in Future");
		 driver.findElement(By.cssSelector("input[name = 'assigntype'][value='U']")).click();
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}
}
