package com.qa.home;
import com.qa.baseMethods.PoiExcelMethods;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Registration_page {
	ResourceBundle element;
	WebDriver driver1; 
	String F_name="";
	String Last_name="";
	String DOB="";
	String email_address="";
	String password="";
	String Confrm_password="";
	PoiExcelMethods refTo_PoiExcelMethods=new PoiExcelMethods();
	
	
	public Registration_page(WebDriver driver) {
		
		this.driver1=driver;
		
		 element= ResourceBundle.getBundle("registration",Locale.US);
	
	}
	
	public void SendToWeb() throws Exception    //sending data to Web
	{
		
		
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("myaccount_btn"))).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("First_name"))).sendKeys(F_name);
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("Last_name"))).sendKeys(Last_name);
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("Dob"))).sendKeys(DOB);			
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("dob_btn"))).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("gender"))).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("select_gender"))).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("Email_Address"))).sendKeys(email_address);
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("pass"))).sendKeys(password);
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("confirm_pass"))).sendKeys(Confrm_password);
		Thread.sleep(5000);
		driver1.findElement(By.xpath(element.getString("submit_btn"))).click();

	}

	
	public void dataFromExcel(String SheetName,int i) throws Exception           //Data reading from Excelfile
	{
		refTo_PoiExcelMethods.getfile();
		F_name = refTo_PoiExcelMethods.getCellData(SheetName, "FirstName", i);
		Last_name = refTo_PoiExcelMethods.getCellData(SheetName, "LastName", i);
		DOB = refTo_PoiExcelMethods.getCellData(SheetName, "DateOfBirth", i);
		email_address = refTo_PoiExcelMethods.getCellData(SheetName, "Email", i);
		password = refTo_PoiExcelMethods.getCellData(SheetName, "Password", i);
		Confrm_password = refTo_PoiExcelMethods.getCellData(SheetName, "ConfirmPassword", i);
	}
	
	
	public void verify(String Actual, int i,int j) throws IOException {

		
		String Expected = refTo_PoiExcelMethods.getCellData("Khaddi", "Expected", j);

		//Set The Actual value
		refTo_PoiExcelMethods.setCellData("Khaddi", 8, j, Actual);
		
		if (Actual.equals(Expected)) {
			
			//Set The Result value
			refTo_PoiExcelMethods.setCellData("Khaddi", i, j, "Pass");
		} else {
			
			refTo_PoiExcelMethods.setCellData("Khaddi", i, j, "Fail");
		}
	
}
}
