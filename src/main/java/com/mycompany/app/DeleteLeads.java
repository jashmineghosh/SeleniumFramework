package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DeleteLeads {

	WebDriver driver;
	@Test
	public void howToDeleteTableData() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		//identifying element using name
		driver.findElement(By.xpath("//a[contains(text(),'jas') and @title='Leads']/parent::td/following-sibling::td[6]//a[text()='del']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'jas') and @title='Leads']/parent::td/following-sibling::td[6]//a[2]")).click(); this also works
		
		//identifying element using position in a table, like 2nd row element
//		driver.findElement(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[4]/td[10]/a[2]")).click();
		
		driver.switchTo().alert().accept();
		//verify if element exists or not
		if(driver.findElements(By.xpath("//a[contains(text(),'jas') and @title='Leads']")).size() == 0)
			System.out.println("deleted");
		else
			System.out.println("exists");
		
	}
}
