package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SwagBase;

public class SwagHomeTest extends SwagBase{
	
	@Test(priority=2)
	public void textVerification() throws Exception
	{
		//test=extent.createTest("ValidHomeTest");
		String text=home.producttextVerification();
		Assert.assertEquals(text, "Products");
		System.out.println("Product text validated");
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="textVerification")
	public void dropdownClick()
	{
	    home.dropdown();
	}
	
	@Test(dependsOnMethods="dropdownClick")
	public void addtocartButton()
	{
		home.cart();
	}
	@Test(dependsOnMethods="addtocartButton")
	public void cartIcon()
	{
		home.iconCart();
		System.out.println("Re-directed to cart page");
	}
	
	

}
