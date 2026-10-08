package test;

import org.testng.annotations.Test;

import base.SwagBase;


public class SwagLoginTest extends SwagBase{
	
	@Test(priority=1)
	public void login() throws Exception
	{
		test=extent.createTest("ValidLoginTest");
		login.setValues("standard_user", "secret_sauce");
		login.loginClick();
		System.out.println("Login Successfull");
		Thread.sleep(3000);
		
	}

}
