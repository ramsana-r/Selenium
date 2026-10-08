package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagCartPage {
	
	WebDriver driver;
	
	By cartText=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By continuebutton=By.xpath("//*[@id=\"continue-shopping\"]");
	By checkoutButton=By.xpath("//*[@id=\"checkout\"]");
	
	public SwagCartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String cartTextverify()
	{
		return driver.findElement(cartText).getText();	

	}
	public boolean continuebuttonCheck()
	{
		return driver.findElement(continuebutton).isEnabled();
		
		
	}
	public boolean checkoutbuttonCheck()
	{
		return driver.findElement(checkoutButton).isEnabled();
	}
	public void checkoutbuttonClick()
	{
		driver.findElement(checkoutButton).click();
	}
}
