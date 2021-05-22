package week5.day2.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;

	@Parameters({"url","username","password"})

	@BeforeMethod(groups="Common")
	public  void setup(String url,String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//STEP1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//STEP2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//STEP 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//STEP4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElementByLinkText("Leads").click();
		
	}
	@AfterMethod(groups="Common")
	public void teatdown() {
		driver.close();
	}
}
