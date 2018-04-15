package actionsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement lnkTutorials=driver.findElement(By.linkText("TUTORIALS"));
		
		Actions action= new Actions(driver);
		action.moveToElement(lnkTutorials).build().perform();
		
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.linkText("Ruby"))).build().perform();
		
		Thread.sleep(1000);
		//action.moveToElement(driver.findElement(By.linkText("Selenium Intermediate Tutorial"))).build().perform();
		driver.findElement(By.linkText("Selenium Intermediate Tutorial")).click();
		
	}
}
