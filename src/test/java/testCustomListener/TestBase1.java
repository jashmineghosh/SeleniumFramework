package testCustomListener;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;

public class TestBase1 {

//	public static WebDriver dr;
	public WebDriver dr;
	public WebEventListener eventListener;
	public EventFiringWebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		
		//extra code for webeventListener, above will work fine for Listener interface
		eventListener = new WebEventListener();
		driver = new EventFiringWebDriver(dr);
		driver.register(eventListener);
	}
}
