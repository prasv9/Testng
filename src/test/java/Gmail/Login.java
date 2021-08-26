package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Browser.BaseClass;

public class Login extends BaseClass {
	
     @Parameter(("usrname"))
	@Test
	private void gmaillogin(String usrname) {
		
	 launchUrl("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	 driver.findElement(By.id("identifierId"));
	sendKeys(usrname);
	 WebElement next = driver.findElement(By.className("VfPpkd-vQzf8d"));
	 buttonClick(next);
	 
	}
}
