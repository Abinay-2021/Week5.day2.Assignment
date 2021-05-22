package week5.day2.Assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	
	@DataProvider(name="fetchData")
	public Object[][] senddata() throws InvalidFormatException, IOException {
		
		String[][] data=ReadExcelData.readExcelData("Duplicate Lead");
		return data;
	}

	@Test(groups="Reg",dependsOnGroups="Sanity", dataProvider="fetchData")
	public void duplicateLead(String emailAddress) throws InterruptedException 
	{

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.linkText("Email")).click();

		driver.findElement(By.name("emailAddress")).sendKeys(emailAddress);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		String LeadName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a")).getText();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();

		driver.findElement(By.xpath("//a[@class='subMenuButton']")).click();

		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Duplicate Lead")) 
		{
			System.out.println("This page is Duplicate Lead");
		}
		else
		{
			System.out.println("The page title is not Duplicate Lead");
		}

		driver.findElement(By.name("submitButton")).click();

		String DupName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if(LeadName.equals(DupName))
		{
			System.out.println("Created Duplicate Name");
		}
		else
		{
			System.out.println("No Duplicate Created");
		}
		
	}
}
