package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyLeadsInfo {

	WebDriver driver;
	@Test
	public void testVerifyLeads() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//*[@id=\"searchAcc\"]/form/table/tbody/tr[1]/td[3]/input")).sendKeys("jas");
		Select select = new Select(driver.findElement(By.id("bas_searchfield")));
		select.selectByValue("firstname");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText("jas")).click();
		String fname = driver.findElement(By.id("mouseArea_First Name")).getText();
		Assert.assertEquals(fname, "Ms.   jas");
		String revamt = driver.findElement(By.id("mouseArea_Annual Revenue")).getText();
		Assert.assertEquals(revamt.substring(2), "20,000"); 
		
	}
}
