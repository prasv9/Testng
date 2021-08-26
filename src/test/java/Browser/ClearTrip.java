package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ClearTrip {
	@Test
	private void book() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Testng\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//div[text()='Trains']")).click();
		driver.findElement(By.xpath("//input[@title='From station']")).sendKeys("Chennai Central");
		driver.findElement(By.xpath("//input[@title='To station']")).sendKeys("Delhi DLI");
		WebElement tclass = driver.findElement(By.id("trainClass"));
		Select select = new Select(tclass);
		select.selectByIndex(3);
		driver.findElement(By.xpath("//input[@value='dd/mm/yyyy']")).sendKeys("05/12/2021");
		//driver.findElement(By.id("cal_showNextMonth")).click();
		//driver.findElement(By.id("cal_showNextMonth")).click();
		//driver.findElement(By.id("cal_showNextMonth")).click();
		driver.findElement(By.xpath("//a[text()='5']")).click();
		WebElement adultchoose = driver.findElement(By.id("train_adults"));
		Select s1 = new Select(adultchoose);
		select.selectByIndex(2);
		WebElement childchoose = driver.findElement(By.id("train_children"));
		Select s2 = new Select(childchoose);
		select.selectByIndex(0);
		WebElement smchoose = driver.findElement(By.id("train_male_seniors"));
		Select s3 = new Select(smchoose);
		select.selectByIndex(0);
		WebElement swchoose = driver.findElement(By.id("train_female_seniors"));
		Select s4 = new Select(swchoose);
		select.selectByIndex(0);
		driver.findElement(By.id("trainFormButton")).click();
		
		
		


	} 

}
