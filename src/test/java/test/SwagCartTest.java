package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SwagBase;

public class SwagCartTest extends SwagBase{
	
	@Test(priority=3)
	public void carttextVerification() throws Exception
	{
		test=extent.createTest("ValidCartTest");
		String text=cart.cartTextverify();
		Assert.assertEquals(text, "Your Cart");
		System.out.println("Cart text validated");
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="carttextVerification")
	public void continueButton()
	{
		boolean continuebuttonresult=cart.continuebuttonCheck();
		System.out.println("Continue button enabled:"+continuebuttonresult);
		Assert.assertTrue(continuebuttonresult, "Continue button is not enabled");
		
	}
	@Test(dependsOnMethods="continueButton")
	public void checkoutButton()
	{
		boolean checkoutbuttonresult=cart.checkoutbuttonCheck();
		System.out.println("Checkout button enabled:"+checkoutbuttonresult);
		Assert.assertTrue(checkoutbuttonresult, "Checkout button is not enabled");
	}
	@Test(dependsOnMethods="checkoutButton")
	public void checkoutButtonclick()
	{
		cart.checkoutbuttonClick();
		System.out.println("Checkout Button clicked and re-directed to checkout page");
	}
	
	

}
