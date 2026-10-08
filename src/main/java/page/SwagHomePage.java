package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SwagHomePage {
	
	WebDriver driver;
	
	By productText=By.cssSelector("span.title");
	By sortField=By.cssSelector("select.product_sort_container");
	By addtocartButton=By.xpath("//*[contains(text(),\"Add to cart\")]");
	By cartIcon=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	
	
	public SwagHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String producttextVerification() 
	{
		return driver.findElement(productText).getText();
	}
	public void dropdown() 
	{
		WebElement dropdown=driver.findElement(sortField);
		Select dropdownoption=new Select(dropdown);
		dropdownoption.selectByVisibleText("Price (low to high)");
		
	}
	public void cart()
	{
		List<WebElement> buttons = driver.findElements(addtocartButton);

	    for (WebElement button : buttons) 
	    {
	        button.click();
	    }
	}
	public void iconCart()
	{
		driver.findElement(cartIcon).click();
		
	}
	
	
	

}
