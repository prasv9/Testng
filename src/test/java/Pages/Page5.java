package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Browser.BaseClass;

public class Page5 extends BaseClass {
	
	public Page5() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id ="order_no")
	private WebElement Orderno;

	public WebElement getOrderno() {
		return Orderno;
	}

	



}
