import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Close_quit {
	public static WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.naukri.com/nlogin/login");
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		
	}


	@Test
	public void test() {
		//driver.navigate().to("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys("raj");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc@566");
		WebElement loginbtn=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		
		List<WebElement> link =driver.findElements(By.tagName("a"));
	System.out.println(link);
	}
	
	@Test
	public void test1() {
	
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys("raj");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc@566");
		WebElement loginbtn=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		
	}
	
	@AfterMethod
	public void tearDown() {
	//driver.quit();
		driver.close();
	}

}
