package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Browser.BaseClass;

public class Page3 extends BaseClass {
	
public Page3() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "radiobutton_0")
	private WebElement radiobutton_0;
	
	@FindBy(xpath= "//input[@type='submit']")
	private WebElement submit;

	public WebElement getRadiobutton_0() {
		return radiobutton_0;
	}

	public WebElement getSubmit() {
		return submit;
	}


}
