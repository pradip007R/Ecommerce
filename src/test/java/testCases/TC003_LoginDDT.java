package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("******test casel of DDt*********");
		//Home page
			
		
				try {
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				logger.info("clicked on myaccount link on the home page..");
				hp.clickLogin(); //Login link under MyAccount
				logger.info("clicked on login link under myaccount..");
				
				//Login page
				LoginPage lp=new LoginPage(driver);
				logger.info("Entering valid email and password..");
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin(); //Login button
				logger.info("clicked on ligin button..");
				
				//My Account Page
				MyAccountPage macc=new MyAccountPage(driver);
						
				boolean targetPage=macc.isMyAccountPageExists();
				if(exp.equalsIgnoreCase("valid"))
				{
					if(targetPage==true) 
					{
					macc.clickLogout();
					Assert.assertTrue(true);
					}
					else 
					{
						Assert.assertTrue(false);
					}
					
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
				}catch(Exception e)
				{
					Assert.fail();
				}
				logger.info("******test casel of DDt in case of finished*********");
	}

}
