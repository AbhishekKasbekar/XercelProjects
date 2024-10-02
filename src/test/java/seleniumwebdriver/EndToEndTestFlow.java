package seleniumwebdriver;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		// Create JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("http://dev:Cgb3u2%e6h$jrG@switchbladeturbo.studioxphl.com/");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products")));
		driver.navigate().to("https://switchbladeturbo.studioxphl.com/productsearch");
		//driver.findElement(By.linkText("Products")).click();

		// Scroll down by 500 pixels (adjust the value for different positions)
		js.executeScript("window.scrollBy(0, 500)");

		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".categoryBoxes"))));

		List<WebElement> products = driver.findElements(By.cssSelector(".ad-industry-item"));

		WebElement prod =

				products.stream()
						.filter(product -> product.findElement(By.cssSelector(".ad-industry-content")).getText()
								.equals("Switchblade Turbo for Caterpillar ACERT 6NZ & C15 & C16 & C18"))
						.findAny().orElse(null);

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
		js.executeScript("window.scrollBy(0, 200)");

		driver.findElement(By.xpath("//button[@title='Select Current Engine Horsepower Rating']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='500 - 850 hp']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath("//button[@title='Select Required Components']")).click();

		driver.findElement(By.xpath("//span[@class='text'][normalize-space()='Only Include Exhaust Manifold']"))
				.click();

		js.executeScript("window.scrollBy(0, 200)");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ad-price")));
		driver.findElement(By.xpath("//input[@name='addcart']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='View Cart']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

		js.executeScript("window.scrollBy(0, 300)");
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("Automateduser@mailinator.com");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='phoneno']"))));
		driver.findElement(By.xpath("//input[@name='phoneno']")).sendKeys("9898989898");
		driver.findElement(By.xpath("//input[@name='accountflag']")).click();

		// js.executeScript("window.scrollBy(0, 200)");

		driver.findElement(By.id("firstname")).sendKeys("NewUser");
		driver.findElement(By.id("middlename")).sendKeys("A");
		driver.findElement(By.id("lastname")).sendKeys("Roy");

		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("//input[@id='streetaddress1']")).sendKeys("Demo street 123");
		driver.findElement(By.xpath("//input[@id='streetaddress2']")).sendKeys("Demo address 2");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Salt lake city");

		
	
		
		
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn dropdown-toggle btn-default")));
		WebElement dropdownContainer = driver.findElement(By.xpath("//button[@data-id='state']"));
//
		dropdownContainer.click();
		dropdownContainer.sendKeys("I");
//		
//		
//
////		 js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 500;", dropdownContainer);
////		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@role='combobox'])[1]"))));
		driver.findElement(By.xpath("(//span[@class='text'][normalize-space()='Idaho'])[1]")).click();
//
//dropdownContainer.click();

		driver.findElement(By.xpath("//input[@id='postalcode']")).sendKeys("84111", Keys.TAB);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shipping_options_row")));



	}

}
