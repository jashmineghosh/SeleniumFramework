package propertiesFileSelenium;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Logout extends TestBase {
	
	
	@Test
	public void logoutTest()
	{
		System.out.println(OR.get("browser"));
		System.out.println(OR.get("url"));
		System.out.println(OR.get("email"));
		System.out.println(OR.get("password"));
		System.out.println(OR.get("login.email"));
		System.out.println(OR.get("login.pwd"));
		System.out.println(OR.get("login.submit"));
	}
}
