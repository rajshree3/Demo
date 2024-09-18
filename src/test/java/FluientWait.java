import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluientWait {
public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
	    WebElement revealed = driver.findElement(By.id("revealed"));
	    driver.findElement(By.id("reveal")).click();

		Wait <WebDriver>wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(1))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(ElementNotInteractableException.class);

		 wait.until(
			        d -> {
			          revealed.sendKeys("Displayed");
			          return true;
			        });

			    Assertion Assertions = null;
				Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
			  }
	}

