package javaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	
	@Test
	public void HighlightObject() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\R\\BrowserDriver\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://test1.absofttrainings.com/");
		
		WebElement shop= driver.findElement(By.linkText("Shop"));
		flash(shop, driver);// To highlight the element
		drawBorder(shop, driver); // To draw a border on element
		/*
		generateAlert(driver, "Caution !!! There is an alert !!!"); // To display an alert
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert(); // To accept alert
		alert.accept();
		*/
		clickElementUsingJS(driver, shop); // Click on element using JavaScript Executor
		Thread.sleep(5000);
		refreshBrowserUsingJS(driver); // To refresh the browser
		
		System.out.println(getTitleUsingJS(driver)); // To get the Page Title using JAva Script Executor
		
		System.out.println(getPageInnerText(driver)); // To get the page source using JS Executor
		
		scrollPageDown(driver); // To Scroll down on page
		Thread.sleep(5000);
		
		WebElement blogLink=driver.findElement(By.linkText("ABSoft's Blog"));
		//WebElement blogLink=driver.findElement(By.xpath("//a[contains(text(),'ABSoft's Blog']"));
		scrollIntoView(driver, blogLink); // To scroll to any element
	}
	
	public static void flash(WebElement element, WebDriver driver) {
	//	JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor= element.getCssValue("backgroundColor");
		for(int i=0; i <10; i++) {
			changeColor("rgb(124,252,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" +color+ "'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserUsingJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleUsingJS(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String title= js.executeScript("return document.title").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText").toString();
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
