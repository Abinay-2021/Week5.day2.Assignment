package week5.day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class MergeLead extends BaseClass
{
	@Test
	public void mergeLead() 
	{
		
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();

		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();
	
		Set<String> allWindows=driver.getWindowHandles();
		List<String> listOfWindows=new ArrayList<String>(allWindows);

		driver.switchTo().window(listOfWindows.get(1));

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.switchTo().window(listOfWindows.get(0));

		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();
		
		allWindows=driver.getWindowHandles();
		listOfWindows=new ArrayList<String>(allWindows);

		driver.switchTo().window(listOfWindows.get(1));
	
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
	
		driver.switchTo().window(listOfWindows.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}