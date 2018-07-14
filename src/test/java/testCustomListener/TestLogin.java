package testCustomListener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestLogin extends TestBase1 {

	@Test
	public void testEventListener()
	{
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebDriverWait  Wait = new WebDriverWait(driver ,100);
	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));
	driver.findElement(By.xpath("//a[@class='login']")).click();;
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jas@jkl.com");
//	driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("jas123");
	driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("jas123");
	driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
	
	}
}
