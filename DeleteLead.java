package week5.day2.Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class DeleteLead extends BaseClass
{
	

	@DataProvider(name="fetchData")
	public Object[][] senddata() throws InvalidFormatException, IOException {
		
		String[][] data=ReadExcelData.readExcelData("Delete Lead");
		return data;
	}

	
	@Test(groups="Delete",dependsOnGroups="Reg", dataProvider="fetchData")
	public void deleteLead(String phoneNumber) throws InterruptedException 
	{

		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String text = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String text2 = text.replaceAll("[A-Za-z ()]","");
		System.out.println(text2);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String recordResult= driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(recordResult);
	if (recordResult.equalsIgnoreCase("No records to display")) {
		
		System.out.println("Records deleted successfully");
	}
	else {
		System.out.println("Records are not deleted");
	}
	}

}
