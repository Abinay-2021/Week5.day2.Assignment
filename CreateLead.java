package week5.day2.Assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass
{
	@DataProvider(name="fetchData")
	public Object[][] senddata() throws InvalidFormatException, IOException {

		String[][] data=ReadExcelData.readExcelData("Create Lead");
		return data;
	}


	// public String[][] sendData() throws InvalidFormatException, IOException {
	//	 ReadExcelData re=new ReadExcelData();
	//	 String[][] data=re.readExcelData();
	//	 return data;
	//  }


	@Test(groups="Smoke", dataProvider="fetchData",invocationCount=3)
	public void createLead(String companyNmae,String firstName,String lastName,String Email
			,String countryCode,String phoneArea,String PhoneNumber) 
	{
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyNmae);

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(Email);

		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();

		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(countryCode);

		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(phoneArea);

		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhoneNumber);

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

	}



}