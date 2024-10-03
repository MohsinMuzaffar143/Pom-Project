package com.qa.baseMethods;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfigure {
public  WebDriver driver;
	
	
	@BeforeMethod
	public WebDriver generateDriverInstance() {
		
		
		ResourceBundle configure= ResourceBundle.getBundle("config",Locale.US);
		
		if(configure.getString("browser").equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		
		else if(configure.getString("browser").equalsIgnoreCase("firefox"))

				{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
				}
		
		
		else if(configure.getString("browser").equalsIgnoreCase("ie"))

		{
			
			WebDriverManager.iedriver().setup();
			
			 driver=new InternetExplorerDriver();
			
				
		}

		else {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		driver.get(configure.getString("appUrl"));
		
	
		
	return driver;
	}

	//@AfterMethod
	public void closeDriver(WebDriver driver) {
		
		driver.quit();
		
	}
	

}
