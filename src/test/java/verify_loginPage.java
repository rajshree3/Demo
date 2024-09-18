import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.BaseClass;

//Data provider
//Assertions

public class verify_loginPage extends BaseClass {
	
	@Test(dataProvider="Data")
	public void verify_valid_testData(String username, String pw ) {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle="Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com";
		System.out.println(ExpectedTitle);
		System.out.println(ActualTitle);
		//Assert equal
		
				Assert.assertEquals(ActualTitle, ExpectedTitle);
				
				//Assert not equal
				
				String ActualTitle1 = driver.getTitle();
				String ExpectedTitle2="Naukari.com";
				System.out.println(ExpectedTitle2);
				System.out.println(ActualTitle1);
				Assert.assertNotEquals(ActualTitle1, ExpectedTitle2);		
				
		
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
		WebElement loginbtn=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		
		// assertNull
		Assert.assertNotNull(username, "data should displayed");
		System.out.println("This stage is pass");
	
		//isDisplaye assertion
		
		Assert.assertTrue(loginbtn.isDisplayed(), "The login button should be displayed");
		System.out.println("The condition is pass");
		loginbtn.click();
	
		/*	WebElement forgotPw=driver.findElement(By.xpath("//small[text()='Forgot Password?']"));
		//AssertFalse
		Assert.assertFalse(forgotPw.isEnabled(),"The btn should be enabled");
		System.out.println("The condition is pass"); */
	}
		
		
		
		
	@DataProvider(name="Data")
	
	public Object[][] dataset()
	{
		return new Object[][] {
			
			{"Raju@gmail.com", "@SF33"},
			//{"praraj1013", "2323sdf"}
		};
	}
}
