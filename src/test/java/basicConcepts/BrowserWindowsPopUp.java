package basicConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserWindowsPopUp {
	
	@Test
	public void WidnowsPopUpTest() {
		
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		String ParentWindow=it.next();
		System.out.println("Parent Widnow ID: "+ParentWindow);
		
		String ChildWindow=it.next();
		System.out.println("Child Widnow Id: "+ChildWindow);
		
		System.out.println("*** On Parent Widnow ***"+driver.getTitle());
		
		driver.switchTo().window(ChildWindow);
		System.out.println("*** On Child Widnow ***"+driver.getTitle());
		
		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println("*** On Parent Widnow ***"+driver.getTitle());
		driver.close();
	}

}
