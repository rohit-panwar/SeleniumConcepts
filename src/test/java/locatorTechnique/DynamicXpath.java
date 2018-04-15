package locatorTechnique;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynamicXpath {
	
	@Test
	public void xpath() {
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://test1.absofttrainings.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//To find dynamic xpath
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		// To find element
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("1stUser:");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test@123");
		
		driver.findElement(By.xpath("//input[contains(@class,'input-text')]")).sendKeys("2ndUser:");
		driver.findElement(By.xpath("//input[contains(@class,'input-')]")).sendKeys("3rdUser:");
		driver.findElement(By.xpath("//input[starts-with(@class,'input')]")).sendKeys("4thUser:");
		driver.findElement(By.xpath("//input[ends-with(@class,'-text')]")).sendKeys("5thUser:");
		//<input id="username" class="input-text" name="username" value="" type="text"/>
	}

}
