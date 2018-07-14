package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TableEx {

	WebDriver driver;
	@Test
	public void howToReadTableData() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		int rowCount = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[3]/td")).size();
		for(int i=3;i<rowCount;i++)
		{
			for (int j= 1;j<colCount;j++)
			{
//				System.out.println(driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr["+i+"]/td["+j+"]")));
				String colData = driver.findElement(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(colData + "|");
				
			}
			System.out.println();
		}
		
	}
}
