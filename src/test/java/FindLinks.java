import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLinks {
  
	public static WebDriver driver;
	
	public static void main(String[]args) throws Exception { 
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/nlogin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			
		List<WebElement> link =driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for (WebElement links : link ) {
			
			String linkUrl= links.getAttribute("href");
			System.out.println(linkUrl);
		
			URL url = new URL(linkUrl);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			httpURLConnection.setConnectTimeout(30000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode()== 200)
				System.out.println(linkUrl + "-" + httpURLConnection.getResponseMessage());
			else 
				System.err.println(linkUrl + "-" + httpURLConnection.getResponseCode());
			
		httpURLConnection.disconnect(); 
		}
         driver.close();
        		}	
		
		
			
}
	

