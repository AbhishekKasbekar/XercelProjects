package seleniumwebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndTestFlow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://dev:Cgb3u2%e6h$jrG@switchbladeturbo.studioxphl.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products")));
		driver.findElement(By.linkText("Products")).click();

		// Create JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by 1000 pixels (adjust the value for different positions)
		js.executeScript("window.scrollBy(0, 500)");



		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".categoryBoxes"))));

		List<WebElement> products = driver.findElements(By.cssSelector(".ad-industry-item"));

		WebElement prod =

				products.stream()
						.filter(product -> product
								.findElement(By.cssSelector(".ad-industry-content"))
								.getText().equals("Switchblade Turbo for Caterpillar ACERT 6NZ & C15 & C16 & C18"))
						.findAny().orElse(null);
		
		js.executeScript("window.scrollBy(0, 200)");

		prod.click();

		// This above logic style is for the getting the all available webelements into
		// the list and then selected the all available options
		// with the prefered choice.

		// js.executeScript("window.scrollBy(0, 200)");

//	WebElement dropdown = driver
//				.findElement(By.cssSelector("button[title='Select Current Engine Horsepower Rating']"));
//		dropdown.click();
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-default")));
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-group bootstrap-select ad-select producttypevar open']//div[@role='combobox']")));
//		
//
//		
//		
		List<WebElement> drpOptions1 = driver.findElements(By.cssSelector(".btn-group"));

		WebElement drpopt1 = drpOptions1.stream()
				.filter(drp -> drp.findElement(By.cssSelector("span")).getText().equals("500 - 850 hp")).findAny()
				.orElse(null);
		drpopt1.click();
//		
//		List<WebElement> drpOptions2 = driver.findElements(By.xpath(
//				"//div[@class='btn-group bootstrap-select ad-select producttypevar open']//div[@role='combobox']"));
//
//		
//		WebElement drpopt2 = drpOptions2.stream()
//				.filter(drp -> drp.findElement(By.cssSelector("span")).getText().equals("Only Include Exhaust Manifold")).findAny()
//				.orElse(null);
//		drpopt2.click();
//		
//		 js.executeScript("window.scrollBy(0, 200)");
//
//	
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ad-price")));
//
//		driver.findElement(By.xpath("//input[@name='addcart']")).click();
//
//		driver.findElement(By.xpath("//a[normalize-space()='View Cart']")).click();
//
//		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
//
////		js.executeScript("window.scrollBy(0, 300)");
//
//		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("Automateduser@mailinator.com");
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='phoneno']"))));
//		driver.findElement(By.xpath("//input[@name='phoneno']")).sendKeys("9898989898");
//		driver.findElement(By.xpath("//input[@name='accountflag']")).click();
//		
//	//	js.executeScript("window.scrollBy(0, 200)");
		
		
	}

}
