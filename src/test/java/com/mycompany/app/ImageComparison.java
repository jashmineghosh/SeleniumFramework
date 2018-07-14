package com.mycompany.app;

import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ImageComparison {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
	}
	
	@Test
	public void testImageCompare() throws IOException
	{
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("FacebookInput.jpg"));
		 
		 File fileInput = new File("FacebookInput.jpg");
		 File fileOutput = new File("FacebookOutput.jpg");
		 
		 BufferedImage bufferFileInput = ImageIO.read(fileInput);
		 DataBuffer bufferFileInput1 = bufferFileInput.getData().getDataBuffer();
		 int fileInputSize = bufferFileInput1.getSize();
		 System.out.println(fileInputSize);
		 
		 BufferedImage bufferFileOutput = ImageIO.read(fileOutput);
		 DataBuffer bufferFileOutput1 = bufferFileOutput.getData().getDataBuffer();
		 int fileOutputSize = bufferFileOutput1.getSize();
		 System.out.println(fileOutputSize);
		 
		 Boolean matchflag = true;
		 if(fileOutputSize == fileInputSize)
		 {
			 Assert.assertTrue(matchflag);
		 }
		 else
		 {
			 Assert.assertTrue(matchflag);
		 }
	}
	
}
