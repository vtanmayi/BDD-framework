package stepDefininitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import BaseUtil.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

/* That class is always run before each test and after each test*/
public class Hooks extends Base{
/*
	private Base base;
	public Hooks( )	{}
	//Dependency Injection
	public Hooks(Base base)
	{
		this.base = base;
	}
	
	@Before
	public void Beginning()
	{
		System.out.println("1. Official web");
	    WebDriverManager.chromedriver().setup();
	 //  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		System.out.println("1. ");
	    base.Driver = new ChromeDriver();
	}
	
	@After
	public void TernDown()
	{ 
		base.Driver.close();
		base.Driver.quit();
		
	}
	
	
	*/
	
}
