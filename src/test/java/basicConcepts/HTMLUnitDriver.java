package basicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HTMLUnitDriver {

	@Test
	public void HTMLUnitBrowserTest() {
		
		WebDriver driver= new HtmlUnitDriver();
		driver.get("http://test1.absofttrainings.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("My Account")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser2");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("testpwd2");

		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.getTitle();
	}
	
}
