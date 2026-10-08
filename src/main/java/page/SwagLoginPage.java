package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By usernameField=By.xpath("//*[@id=\"user-name\"]");
	By passwordField=By.xpath("//*[@id=\"password\"]");
	By loginButton=By.xpath("//*[@id=\"login-button\"]");

	
	public SwagLoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public void setValues(String username,String password)
	{
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		
	}
	public void loginClick()
	{
		driver.findElement(loginButton).click();
	}
	

}
