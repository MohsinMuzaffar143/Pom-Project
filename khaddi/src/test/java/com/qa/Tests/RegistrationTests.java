package com.qa.Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseMethods.PoiExcelMethods;
import com.qa.pages.Registration_page;
import com.qa.baseMethods.BrowserConfigure;
public class RegistrationTests {

	
	PoiExcelMethods dm= new PoiExcelMethods();
	WebDriver driver;
	Registration_page dataset;
	BrowserConfigure a;
	
	@Test
	public void FirstNameEmpty() throws Exception {
		
		dataset.dataFromExcel("Khaddi", 1);
		dataset.SendToWeb();
		String Actual = driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("aria-describedby");
		

		dataset.verify(Actual,9,1);
			
	}


	@Test
	public void LastNameEmpty() throws Exception {
		dataset.dataFromExcel("Khaddi", 2);
		dataset.SendToWeb();
		String Actual = driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("aria-describedby");

		dataset.verify(Actual,9,2);
			
	}
	
	
	@BeforeMethod
	public void launch() {
		 a= new BrowserConfigure();
		driver= a.generateDriverInstance();
		dataset=new Registration_page(driver);

	}
}
