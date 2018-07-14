package com.mycompany.app;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadInSelenium {

	WebDriver driver;

	@BeforeTest
	public void StartBrowser() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		  FirefoxOptions profile = new FirefoxOptions();
		 profile.addPreference("browser.download.dir", "C:\\Users\\user\\Downloads");
		 profile.addPreference("browser.download.folderList", 2);
		 
		 profile.addPreference("browser.download.manager.alertOnEXEOpen", false);
		 profile.addPreference("browser.helperApps.neverAsk.saveToDisk",
		       "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
		 profile.addPreference("browser.download.manager.showWhenStarting", false);
		 profile.addPreference("browser.download.manager.focusWhenStarting", false);
		 profile.addPreference("browser.download.useDownloadDir", true);
		 profile.addPreference("browser.helperApps.alwaysAsk.force", false);
		 profile.addPreference("browser.download.manager.alertOnEXEOpen", false);
		 profile.addPreference("browser.download.manager.closeWhenDone", true);
		 profile.addPreference("browser.download.manager.showAlertOnComplete", false);
		 profile.addPreference("browser.download.manager.useWindow", false);
		 profile.addPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
		  
		
			profile.addPreference("browser.helperApps.neverAsk.saveToDisk", 
				    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 

		 profile.addPreference( "pdfjs.disabled", true );
		 driver = new FirefoxDriver(profile);
	}
		 @Test
		 public void OpenURL() throws InterruptedException
		 {
			 File file = new File("C:\\Users\\user\\Downloads\\eclipse-inst-win64.exe");
			 if(file.exists())
			 {
				 file.delete();
				 System.out.println("file is deleted");
			 }
			 driver.get("http://www.eclipse.org/downloads/");
			 driver.findElement(By.xpath("//*[@id=\"tool-platforms\"]/div/div/div[1]/div/p[2]/a")).click();
			 driver.findElement(By.xpath("//*[@id=\"novaContent\"]/div[1]/div[1]/div/div/a")).click();
			 
			 while(!file.exists())
			 {
				 System.out.println("file is downloading");
				 Thread.sleep(8000);
			 }
			 long len ;
			 do
			 {
				  len = file.length();
				 System.out.println("file size is :" + len);
			 }
			 while(len == 0);
			 	 
			 
		 }
		
	}

	


