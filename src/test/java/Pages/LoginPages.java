package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	
	public LoginPages(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(how = How.NAME, using ="uid")
	public WebElement UserName;

	@FindBy(how = How.NAME, using ="password")
	public WebElement Password;
	
	@FindBy(how = How.NAME, using ="btnLogin")
	public WebElement LoginBtn;
	
	@FindBy(how = How.NAME, using ="btnReset")
	public WebElement ResetBtn;
	
	
	public void ResetInputs() 
	{
		ResetBtn.click();
	}
	
	
	public void EnterLoginCredentials(String _userName, String _pass) 
	{
		UserName.sendKeys(_userName);
		Password.sendKeys(_pass);
		
	}
	public void ClickLogin() 
	{
		LoginBtn.click();
	}
	
	
	
	
}
