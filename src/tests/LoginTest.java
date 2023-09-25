package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;


	public class LoginTest {
		
		/* 
		 * 
		 * Author-Mital
		 */
		
		LoginPage lp = new LoginPage();
		DataFile df= new DataFile();
		
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  lp.openBrowser();
		  lp.openLoginPage();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  lp.closeBrowser();
	  }
	  
	  @Test (priority = 1)
	  public void loginWithSpecialCharEmailTest() throws InterruptedException {
		  lp.login(df.specialCharEmail, df.wrongPassword); 
		  Assert.assertEquals(lp.readEmailErr(), df.SpecialCharErr);
	  }
	  
	  @Test (priority = 2)
	  public void loginWithEmptyEmailTest() throws InterruptedException {
		  lp.login("", df.wrongPassword);	  
		  Assert.assertEquals(lp.readEmailErr(),df.emptyEmailErr);
	  }
	  
	  @Test (priority = 3)
	  public void loginWithEmptyPasswordTest() throws InterruptedException {
		  lp.login(df.wrongEmail, "");  
		  Assert.assertEquals(lp.readPasswordErr(),df.emptyPasswordErr);
	  }
	  
	  @Test (priority = 4)
	  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
		  lp.login(df.wrongEmail, df.wrongPassword);
		  Assert.assertEquals(lp.readGlobalErr(), df.globalErr);
	  }
	  

	}

