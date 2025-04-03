package tataHealth_Smoke_Integreation_System_Test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tata_health_ObjectRepository.POM.AddDoctorPage;
import tata_health_ObjectRepository.POM.AddDoctorSpecializationPage;
import tata_health_ObjectRepository.POM.AdminDashBoardPage;
import tata_health_ObjectRepository.POM.AdminLoginPage;
import tata_health_ObjectRepository.POM.ContactUsPage;
import tata_health_ObjectRepository.POM.DoctorDashboardPage;
import tata_health_ObjectRepository.POM.DoctorLoginPage;
import tata_health_ObjectRepository.POM.HomePage;
import tata_health_ObjectRepository.POM.Patient_UserSignUpPage;
import tata_health_generic_BaseUtility.BaseClassTest;
import tata_health_generic_ListenerUtility.Retry;

public class TH_Smoke_IT_Test extends BaseClassTest {

	/* 1===> Smoke Test - Login to Admin Panel */

	@Test(groups = "SmokeTest", retryAnalyzer = Retry.class)
	public void LoginToAdminPanel_Test() throws Throwable {
		String URL = pflib.getDatafromPropertiesFile("url");
		String USERNAME = pflib.getDatafromPropertiesFile("username");
		String PASSWORD = pflib.getDatafromPropertiesFile("password");
		AdminLoginPage Alp = new AdminLoginPage(driver);
		Alp.loginToAdminPanel(URL, USERNAME, PASSWORD);
		
		// logout as admin 
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("1.....Smoke TC....-LoginToAdminPanel_Test====>Passed");
	}
//=======================================================================================================//
	/* 2===> Smoke Test - Register a Patient */

	@Test(groups = "SmokeTest", retryAnalyzer = Retry.class)
	public void RegisterAPatient_Test() throws Throwable {

		String SignUpUrl = elib.getDataFromExcel("User", 1, 0);

		System.out.println(SignUpUrl);
		String FullName = elib.getDataFromExcel("User", 1, 2) + jlib.getRandomNumber();
		String Address = elib.getDataFromExcel("User", 1, 3);
		String City = elib.getDataFromExcel("User", 1, 4);
		String R_Email = elib.getDataFromExcel("User", 1, 5) + jlib.getRandomNumber();
		String Email = R_Email + "@pu.com";
		String Password = FullName;

		Patient_UserSignUpPage pusp = new Patient_UserSignUpPage(driver);
		pusp.Patient_UserSignUpForFemale(SignUpUrl, FullName, Address, City, Email, Password);
		System.out.println("2.....Smoke TC....-RegisterAPatient_Test====>Passed");

	}
//=====================================================================================================//
	/* 3===> Integration Test - To verify contact us queries */
	
	@Test(groups = "IntegrationTest",retryAnalyzer = Retry.class)
	public void VerifyContactUsQuery_Test() throws Throwable {
		waitForPageToLoad(driver);
		String ContactUsUrl = elib.getDataFromExcel("ContactUs", 1, 0);
		String FullName = elib.getDataFromExcel("ContactUs", 1, 1) + jlib.getRandomNumber();
		String R_Email = elib.getDataFromExcel("ContactUs", 1, 2) + jlib.getRandomNumber();
		String Email = R_Email + "@query.com";
		String Mobile = elib.getDataFromExcel("ContactUs", 1, 3);
		String Description = elib.getDataFromExcel("ContactUs", 1, 4);

		ContactUsPage cup = new ContactUsPage(driver);
		cup.SendContactQuery(ContactUsUrl, FullName, Email, Mobile, Description);
		Thread.sleep(5000);
		Alert ale = driver.switchTo().alert(); //  delayed 
		Thread.sleep(1000);
		ale.accept();

		/* verify contact us query through AdminPanel */
		cup.getHomeButton().click(); // 
		HomePage hp = new HomePage(driver);
	    Actions act = new Actions(driver);
		act.scrollByAmount(900, 800).perform();
		Thread.sleep(5000); //without wait its not working
	//act.moveToElement(hp.getAdminLoginLink()).click().perform(); //element calling through pompage is not working
		WebElement Adminlogin = driver.findElement(By.xpath("//a[@href='hms/admin']"));
		Adminlogin.click();
		Thread.sleep(6000); //without wait its not working
		//act.scrollToElement(hp.getAdminLoginLink()).click().perform();
		// String URL = pflib.getDatafromPropertiesFile("url");
			String USERNAME = pflib.getDatafromPropertiesFile("username");
			String PASSWORD = pflib.getDatafromPropertiesFile("password");
			AdminLoginPage Alp = new AdminLoginPage(driver);
			Alp.loginToAdminPanel(USERNAME, PASSWORD);
			AdminDashBoardPage adbp = new AdminDashBoardPage(driver);
			adbp.getTotalNewQueriesLink().click();
			
			String ActName = null;
			String ExpName = FullName;
			List<WebElement> queryNames = driver.findElements(By.xpath("//tbody/tr/td[@class='hidden-xs']")) ;
			for(WebElement Name : queryNames) {	
				System.out.println(Name.getText()); 
				ActName = Name.getText();
			}
			System.out.println("Exp name is ===>"+ ExpName);  
			System.out.println("Act name is ===>"+ ActName); 
			Assert.assertEquals(ExpName, ActName);
// logout as admin 
	driver.findElement(By.xpath("//span[@class='username']")).click();
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	System.out.println("3..... Integration TC....-VerifyContactUsQuery_Test===>Passed");
	}
//=====================================================================================================//

	/* 4===> Integration Test - To verify Doctor login */
	
	@Test(groups = "IntegrationTest", retryAnalyzer = Retry.class)
	public void VerifyDoctorLogin_Test() throws Throwable {
		
		String URL = elib.getDataFromExcel("Doctor", 1, 0);
		String USERNAME = elib.getDataFromExcel("Doctor", 1, 1);
		String PASSWORD = elib.getDataFromExcel("Doctor", 1, 2);
		
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.loginToDoctorPanel(URL, USERNAME, PASSWORD);
		
		DoctorDashboardPage ddbp = new DoctorDashboardPage(driver);
		ddbp.getDoctorLookupImg().getText();
		//verify dr. login
		String Doctor = ddbp.getDoctorLookupImg().getText();
		boolean AvailDr =  Doctor.contains(PASSWORD);
		Assert.assertEquals(AvailDr, true);
		System.out.println("Dr. login verified");
		//logout
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("4......Integration TC....-VerifyDoctorLogin_Test===>Passed");
	}
}
