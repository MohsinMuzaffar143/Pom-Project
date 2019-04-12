package com.qa.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseMethods.PoiExcelMethods;
import com.qa.home.Registration_page;
import com.qa.baseMethods.BrowserConfigure;
public class RegistrationTests {

	
	PoiExcelMethods dm= new PoiExcelMethods();
	WebDriver driver;
	Registration_page dataset;
	BrowserConfigure a;
	
	@Test(priority=1)
	public void FirstNameEmpty() throws Exception {
		
		dataset.dataFromExcel("Khaddi", 1);
		dataset.SendToWeb();
		String Actual = driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,1);
			
	}


	@Test(priority=2)
	public void LastNameEmpty() throws Exception {
		dataset.dataFromExcel("Khaddi", 2);
		dataset.SendToWeb();
		String Actual = driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,2);
			
	}
	
	
	
	@Test(priority = 3)
	public void EmptyEmail() throws InterruptedException, Exception {
		//Calling Function
		dataset.dataFromExcel("Khaddi", 3);
		dataset.SendToWeb();
		//Getting The Attribute
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//input[@id='email_address']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,3);

	}
	
	@Test(priority = 4)
	public void EmptyPass() throws Exception {
		
		dataset.dataFromExcel("Khaddi", 4);
		dataset.SendToWeb();
		//Getting The Attribute
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,4);

	}
	
	
	@Test(priority = 5)
	public void EmptyConfirmPass() throws Exception {
		dataset.dataFromExcel("Khaddi", 5);
		dataset.SendToWeb();
		//Getting The Attribute
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//input[@id='password-confirmation']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,5);
}
	
	
	@Test(priority = 6)
	public void PoorPass() throws Exception {
		dataset.dataFromExcel("Khaddi", 6);
		dataset.SendToWeb();
		//Getting The Attribute
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//div[@id='password-strength-meter']")).getText();

		dataset.verify(Actual,9,6);
		
	}
	
	
	@Test(priority = 7)
	public void WrongEmail() throws Exception {
		dataset.dataFromExcel("Khaddi", 7);
		dataset.SendToWeb();
		//Getting The Attribute
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//input[@id='email_address']")).getAttribute("aria-describedby");
		dataset.verify(Actual,9,7);
		
	}
	
	@BeforeMethod
	public void launch() {
		a= new BrowserConfigure();
		driver= a.generateDriverInstance();
		dataset=new Registration_page(driver);

	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
