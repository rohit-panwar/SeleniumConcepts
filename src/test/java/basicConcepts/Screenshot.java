package basicConcepts;

//import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import javax.swing.plaf.FileChooserUI;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.TakesScreenshot;


public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://facebook.com");
		//Thread.sleep(3000);
		
	//	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("/Downloads/Facebook.png"));
		driver.quit();

	}

}
