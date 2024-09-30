package seleniumwebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo {
	
	@Test
	
	public void methods()
	{
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demo.guru99.com/V4/index.php");
		
		driver.findElement(By.xpath("//input[@name=\"uid\"]")).sendKeys("mngr589159");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("pyzAsEq");
		driver.findElement(By.xpath("//input[@name=\"btnLogin\"]")).click();
		

		
		SoftAssert softAssert = new SoftAssert(); 
		
		String actualTitle = driver.getTitle();
	softAssert.assertEquals(actualTitle, "Guru99 Bank Manager HomePage", "Title is not matched");
	softAssert.assertAll();
		
		
		
		
	}

}
