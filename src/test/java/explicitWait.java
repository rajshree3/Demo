import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class explicitWait {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/nlogin/login");
		driver.manage().window().maximize();
		
		Wait <WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		WebElement link= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]")));
		link.click();
		System.out.println("The text is =" + link.getText());
		driver.close();
		
	}

}
