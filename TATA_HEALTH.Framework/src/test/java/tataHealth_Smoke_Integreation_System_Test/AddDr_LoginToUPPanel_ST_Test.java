package tataHealth_Smoke_Integreation_System_Test;

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
import tata_health_ObjectRepository.POM.BookAppointmentPage;
import tata_health_ObjectRepository.POM.HomePage;
import tata_health_ObjectRepository.POM.Patient_UserDashboardPage;
import tata_health_ObjectRepository.POM.Patient_UserLoginPage;
import tata_health_ObjectRepository.POM.Patient_UserSignUpPage;
import tata_health_generic_BaseUtility.BaseClassTest;
import tata_health_generic_ListenerUtility.Retry;

public class AddDr_LoginToUPPanel_ST_Test extends BaseClassTest {

	/* 1===> System Test - Add a doctor */

	@Test(groups = "SystemTest", retryAnalyzer = Retry.class)
	public void addADoctor_Test() throws Throwable {
		/* login to admin panel */
		String URL = pflib.getDatafromPropertiesFile("url");
		String USERNAME = pflib.getDatafromPropertiesFile("username");
		String PASSWORD = pflib.getDatafromPropertiesFile("password");
		AdminLoginPage Alp = new AdminLoginPage(driver);
		Alp.loginToAdminPanel(URL, USERNAME, PASSWORD);

		/* add dr. specialization */

		AdminDashBoardPage adbp = new AdminDashBoardPage(driver);
		adbp.getDoctorsButton().click();
		Thread.sleep(2000);
		adbp.getDoctorSpecializationButton().click();
		AddDoctorSpecializationPage adsp = new AddDoctorSpecializationPage(driver);
		adsp.getDoctorSpecializationEdit().sendKeys("Hepatologist");
		adsp.getSubmitButton().click();
		System.out.println("Dr. Specialization added");

		/* Add a dr. */

		Thread.sleep(2000);
		adsp.getDoctorsButton().click();
		Thread.sleep(2000);
		adsp.getAddDoctorButton().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.getDoctorspecializationDD().click();
		Select sel = new Select(adp.getDoctorspecializationDD());
		sel.selectByVisibleText("Hepatologist");

		String DrName = elib.getDataFromExcel("Doctor", 1, 3) + jlib.getRandomNumber();
		String ClinicAddess = elib.getDataFromExcel("Doctor", 1, 4);
		String Fee = elib.getDataFromExcel("Doctor", 1, 5);
		String Contact = elib.getDataFromExcel("Doctor", 1, 6);
		String Email = elib.getDataFromExcel("Doctor", 1, 7) + jlib.getRandomNumber();
		String D_Email = Email + "@dr.com";
		String Password = DrName;

		Actions act = new Actions(driver);
		act.moveToElement(adp.getDoctorNameEdit()).click().sendKeys(DrName).perform();

		// adp.getDoctorNameEdit().sendKeys(DrName);
		adp.getDoctorClinicAddressEdit().sendKeys(ClinicAddess);
		adp.getDoctorContactEdit().sendKeys(Contact);
		adp.getDoctorConsultancyFeesEdit().sendKeys(Fee);
		adp.getDoctorEmailEdit().sendKeys(D_Email);
		adp.getPasswordEdit().sendKeys(Password);
		adp.getConfirmPasswordEdit().sendKeys(Password);
		adp.getSubmitButton().click();

		/* handle alert */
		Thread.sleep(3);
		Alert ale = driver.switchTo().alert();
		ale.accept();
		System.out.println("Dr. is added successfully");
		/* logout */
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("4......System TC.....- addADoctor_Test====> Passed");
	}

	/* 2 ===> System Test - Login To User_patient Panel */

	@Test(groups = "SystemTest", retryAnalyzer = Retry.class)
	public void LoginToUser_patientPanel_Test() throws Throwable {

		String SignUpUrl = elib.getDataFromExcel("User", 1, 0);
		String FullName = elib.getDataFromExcel("User", 1, 2) + jlib.getRandomNumber();
		String Address = elib.getDataFromExcel("User", 1, 3);
		String City = elib.getDataFromExcel("User", 1, 4);
		String R_Email = elib.getDataFromExcel("User", 1, 5) + jlib.getRandomNumber();
		String Email = R_Email + "@pu.com";
		String Password = FullName;
		Patient_UserSignUpPage pusp = new Patient_UserSignUpPage(driver);
		pusp.Patient_UserSignUpForFemale(SignUpUrl, FullName, Address, City, Email, Password);
		System.out.println("User_patient registration done");

		Patient_UserSignUpPage pusup = new Patient_UserSignUpPage(driver);
		Actions act = new Actions(driver);
		act.scrollByAmount(800, 900).perform();
		Thread.sleep(2);
		// act.moveToElement(pusup.getLoginLink()).click();
		driver.findElement(By.xpath("//a[@href='user-login.php']")).click();

		Patient_UserLoginPage pulp = new Patient_UserLoginPage(driver);
		pulp.loginToPatientPanel(Email, Password);
		System.out.println("Patient login done");

		Patient_UserDashboardPage pudbp = new Patient_UserDashboardPage(driver);
		String Patient_user = pudbp.getUserLookupImg().getText();
		boolean AvailUP = Patient_user.contains(FullName);
		Assert.assertEquals(AvailUP, true);
		System.out.println("Patient_user. login verified");
		/* logout */
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("4......System TC....- LoginToUser_patientPanel_Test====> Passed");

	}
	
}
