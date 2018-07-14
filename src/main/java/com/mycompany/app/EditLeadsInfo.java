package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class EditLeadsInfo {

	WebDriver driver;
	@Test
	public void howToEditTableData() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[contains(text(),'jas') and @title='Leads']/parent::td/following-sibling::td[6]//a[text()='edit']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'jas') and @title='Leads']/parent::td/following-sibling::td[6]//a[1]")).click(); this also works
		driver.findElement(By.xpath("//input[@name='country']")).clear();
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("US");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("jas")).click();
		String cname = driver.findElement(By.id("mouseArea_Country")).getText();
		Assert.assertEquals(cname.substring(2), "US");
		
	}
	
	
}
