package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SwagBase;

public class SwagCheckoutTest extends SwagBase{
	
	@Test(priority=4)
	public void checkouttextVerification() throws Exception
	{
		test=extent.createTest("ValidCheckoutTest");
		String text=checkout.checkouttextValidation();
		Assert.assertEquals(text, "Checkout: Your Information");
		System.out.println("Checkoutpage text validated");
		Thread.sleep(3000);
	
	}
	
	@Test(dependsOnMethods="checkouttextVerification")
	public void setvaluesCheckout()
	{
		checkout.setValues("Zayn", "Ishaan", "689501");
		checkout.continueClick();
		checkout.finishClick();
		System.out.println("Order placed successfully");
	}
	
	

}
