package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagCheckoutPage {
	
	WebDriver driver;
	
	By checkoutText=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By firstnameField=By.xpath("//*[@id=\"first-name\"]");
	By lastnameField=By.xpath("//*[@id=\"last-name\"]");
	By zipcodeField=By.xpath("//*[@id=\"postal-code\"]");
	By continueButton=By.xpath("//*[@id=\"continue\"]");
	By finishButton=By.xpath("//*[@id=\"finish\"]");
	
	
	public SwagCheckoutPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String checkouttextValidation()
	{
		return driver.findElement(checkoutText).getText();
	}
	
	public void setValues(String firstname,String lastname,String zipcode)
	{
		driver.findElement(firstnameField).sendKeys(firstname);
		driver.findElement(lastnameField).sendKeys(lastname);
		driver.findElement(zipcodeField).sendKeys(zipcode);
		
	}
	public void continueClick()
	{
		driver.findElement(continueButton).click();
	}
	public void finishClick()
	{
		driver.findElement(finishButton).click();
	}
	
	
	

}
