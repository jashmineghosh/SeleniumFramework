/**
 * 
 */
/**
 * @author user
 *
 */
package propertiesFileSelenium;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends TestBase{
	
	
	
	@Test
	public void loginTest()
	{
//		System.out.println(OR.get("browser"));
//		System.out.println(OR.get("url"));
//		System.out.println(OR.get("email"));
//		System.out.println(OR.get("password"));
//		System.out.println(OR.get("login.email"));
//		System.out.println(OR.get("login.pwd"));
		System.out.println(OR.get("login.submit"));
		OR.get("browser");
		OR.get("url");
		OR.get("email");
		OR.get("password");
		OR.get("login.email");
		OR.get("login.pwd");
		OR.get("login.submit");
		System.out.println(OR.getProperty("browser"));
	}
}