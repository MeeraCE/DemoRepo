package tests1;

import org.testng.annotations.Test;

import data1.DataFile;

import java.io.IOException;

import org.testng.Assert;
import pages1.TestPage;
import utilities1.Xls_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
 TestPage tp = new TestPage();
 DataFile df = new DataFile();
 
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  tp.openbrowser();
      tp.openloginpage();
  }

  @AfterMethod
  public void afterMethod() {
	  tp.closebrowser();
	   
  }
  
  @Test(priority = 1)
  public void loginWithSpecialCharEmailTest() throws InterruptedException {
  
	  tp.login(df.emailWithSpecialChar, df.wrongPassword);
	  Assert.assertEquals(tp.readEmailError(),  df.specialCharErr);
}
  
  @Test(priority = 2)
  public void LoginWithEmptyEmailTest() throws InterruptedException {
  
        tp.login("", df.wrongPassword);
	    Assert.assertEquals(tp.readEmailError(), df.emptyEmailErr);
        
}
  
  @Test(priority = 3)
  public void LoginWithEmptyPasswordTest() throws InterruptedException {
	  
	  tp.login(df.wrongEmail, "");
	  Assert.assertEquals(tp.readPasswordError(), df.emptyPassErr);
  }
  
  @Test(priority = 4)
  public void LoginWithWrongEmailAndPassword() throws InterruptedException {
	  
	  tp.login(df.wrongEmail, df.wrongPassword);
	  Assert.assertEquals(tp.readGlobalError(), df.globalErr);
  }
}
