package basicConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// To launch the driver
		driver.get("https://google.co.in");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		// To navigate to other URL
		driver.navigate().to("https://facebook.com");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		// To navigate back to google page
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		// To navigate forward to facebook page
		driver.navigate().forward();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		// To refresh the browser
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		// To close the browser
		driver.quit();

	}

}
