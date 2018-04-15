package locatorTechnique;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FindElements {

	@Test
	public void xpath() {
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://test1.absofttrainings.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List <WebElement> allLink= driver.findElements(By.tagName("a"));
		System.out.println("Total Links: "+allLink.size());
		
		for(int i=0; i<allLink.size(); i++) {
			String s=allLink.get(i).getText();
			{
				if(s.length()==0)
					System.out.println(i+1+": ***** BLANK *****");
				else
					System.out.println(i+1+":"+s);
			}
			//System.out.println(i+1+":"+s);
		}
		driver.quit();
	}
}