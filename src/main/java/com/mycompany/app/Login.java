package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mycompany.app.helper.logger.LoggerHelper;

public class Login {

	WebDriver driver;
	public Logger log = LoggerHelper.getLogger(Login.class);
	@Test
	public void testLogin()
	{
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		log.info("testing log msg");
}
}
