package tataHealth_Smoke_Integreation_System_Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import tata_health_ObjectRepository.POM.AddDoctorPage;
import tata_health_ObjectRepository.POM.AddDoctorSpecializationPage;
import tata_health_ObjectRepository.POM.AddMedicalHistoryPage;
import tata_health_ObjectRepository.POM.AddPatientPage;
import tata_health_ObjectRepository.POM.AdminDashBoardPage;
import tata_health_ObjectRepository.POM.AdminLoginPage;
import tata_health_ObjectRepository.POM.BookAppointmentPage;
import tata_health_ObjectRepository.POM.DoctorDashboardPage;
import tata_health_ObjectRepository.POM.DoctorLoginPage;
import tata_health_ObjectRepository.POM.HomePage;
import tata_health_ObjectRepository.POM.Patient_UserDashboardPage;
import tata_health_ObjectRepository.POM.Patient_UserLoginPage;
import tata_health_ObjectRepository.POM.Patient_UserSignUpPage;
import tata_health_generic_BaseUtility.BaseClassTest;
import tata_health_generic_ListenerUtility.Retry;

public class BookAppointment_AddMediHistory_ST_Test extends BaseClassTest {

	@Test(groups = "SystemTest",retryAnalyzer = Retry.class)
	public void BookAnAppointment_ST_Test() throws Throwable {
// 1. login as admin
		String URL = pflib.getDatafromPropertiesFile("url");
		String USERNAME = pflib.getDatafromPropertiesFile("username");
		String PASSWORD = pflib.getDatafromPropertiesFile("password");
		AdminLoginPage Alp = new AdminLoginPage(driver);
		Alp.loginToAdminPanel(URL, USERNAME, PASSWORD);
// 2. create a dr. with specialization
		AdminDashBoardPage adbp = new AdminDashBoardPage(driver);
		adbp.getDoctorsButton().click();
		Thread.sleep(2000);
		adbp.getDoctorSpecializationButton().click();
		AddDoctorSpecializationPage adsp = new AddDoctorSpecializationPage(driver);
		adsp.getDoctorSpecializationEdit().sendKeys("Pharmasist");
		adsp.getSubmitButton().click();
		System.out.println("Dr. Specialization added");
// 3. Add a dr.
		Thread.sleep(2000);
		adsp.getDoctorsButton().click();
		Thread.sleep(2000);
		adsp.getAddDoctorButton().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.getDoctorspecializationDD().click();
		Select sel = new Select(adp.getDoctorspecializationDD());
		sel.selectByVisibleText("Pharmasist");

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
// logout as admin 
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();

// 4. register a user
		HomePage hp = new HomePage(driver);
		act.scrollByAmount(900, 800).perform();
		Thread.sleep(5000); // without wait its not working
		WebElement Patientlogin = driver.findElement(By.xpath("//a[@href='hms/user-login.php']"));
		Patientlogin.click();
		Thread.sleep(2000);
		Patient_UserLoginPage pulp = new Patient_UserLoginPage(driver);
		pulp.getCreateAnAccountLink().click();

		String FullName = elib.getDataFromExcel("User", 1, 2) + jlib.getRandomNumber();
		String Address = elib.getDataFromExcel("User", 1, 3);
		String City = elib.getDataFromExcel("User", 1, 4);
		String R_Email = elib.getDataFromExcel("User", 1, 5) + jlib.getRandomNumber();
		String PU_Email = R_Email + "@pu.com";
		String PU_Password = FullName;
		Patient_UserSignUpPage pusp = new Patient_UserSignUpPage(driver);
		pusp.Patient_UserSignUpForMale(FullName, Address, City, PU_Email, PU_Password);
		System.out.println("User_patient registration done");
// naviagte to user login page
		act.scrollByAmount(800, 900).perform();
		Thread.sleep(2);
		// act.moveToElement(pusp.getLoginLink()).click();
		driver.findElement(By.xpath("//a[@href='user-login.php']")).click();
// 5. login as user
		pulp.loginToPatientPanel(PU_Email, PU_Password);
		System.out.println("Patient_user login done");
// 6. book appointment
		Patient_UserDashboardPage pudbp = new Patient_UserDashboardPage(driver);
		pudbp.getBookAppointmentBtn().click();
		BookAppointmentPage bap = new BookAppointmentPage(driver);
		Thread.sleep(3);
		bap.getDoctorspecializationDD().click();
		Thread.sleep(3);
		sel.selectByVisibleText("Pharmasist");
		act.moveToElement(bap.getDoctorDD()).click().perform();
		Thread.sleep(2);
		sel.selectByIndex(01);
//		sel.selectByValue(DrName);
		Thread.sleep(1);
		bap.getDateEdit().click();
		String AppointmentDate = jlib.getSystemDate();
		bap.getDateEdit().sendKeys(AppointmentDate,Keys.TAB, Keys.TAB);
		Thread.sleep(3);
		//act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); // date handling-need to learn
		//act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); // time handling - need to learn
		bap.getSubmitButton().click();
		Thread.sleep(3);
		ale.accept();
// 7. verify appointment
		/* logout */
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("7.....System TC....-BookAnAppointment_ST_Test===> Passed");
	}
	
//============================================================================================================//

	@Test(groups = "SystemTest", retryAnalyzer = Retry.class)
	public void AddMedicalHistory_ST_Test() throws Throwable {
// 1. login as admin
		String URL = pflib.getDatafromPropertiesFile("url");
		String USERNAME = pflib.getDatafromPropertiesFile("username");
		String PASSWORD = pflib.getDatafromPropertiesFile("password");
		AdminLoginPage Alp = new AdminLoginPage(driver);
		Alp.loginToAdminPanel(URL, USERNAME, PASSWORD);
// 2. add dr. specialization
		AdminDashBoardPage adbp = new AdminDashBoardPage(driver);
		adbp.getDoctorsButton().click();
		Thread.sleep(2000);
		adbp.getDoctorSpecializationButton().click();
		AddDoctorSpecializationPage adsp = new AddDoctorSpecializationPage(driver);
		adsp.getDoctorSpecializationEdit().sendKeys("opthalmologist");
		adsp.getSubmitButton().click();
		System.out.println("Dr. Specialization added");
// 3. add a dr.
		Thread.sleep(2000);
		adsp.getDoctorsButton().click();
		Thread.sleep(2000);
		adsp.getAddDoctorButton().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.getDoctorspecializationDD().click();
		Select sel = new Select(adp.getDoctorspecializationDD());
		sel.selectByVisibleText("opthalmologist");
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
// 4. logout as admin
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
// 5. register as user
		HomePage hp = new HomePage(driver);
		act.scrollByAmount(900, 800).perform();
		Thread.sleep(5000); // without wait its not working
		WebElement Patientlogin = driver.findElement(By.xpath("//a[@href='hms/user-login.php']"));
		Patientlogin.click();
		Thread.sleep(2000);
		Patient_UserLoginPage pulp = new Patient_UserLoginPage(driver);
		pulp.getCreateAnAccountLink().click();
		String FullName = elib.getDataFromExcel("User", 1, 2) + jlib.getRandomNumber();
		String Address = elib.getDataFromExcel("User", 1, 3);
		String City = elib.getDataFromExcel("User", 1, 4);
		String R_Email = elib.getDataFromExcel("User", 1, 5) + jlib.getRandomNumber();
		String PU_Email = R_Email + "@pu.com";
		String PU_Password = FullName;
		Patient_UserSignUpPage pusp = new Patient_UserSignUpPage(driver);
		pusp.Patient_UserSignUpForMale(FullName, Address, City, PU_Email, PU_Password);
		System.out.println("User_patient registration done");
// naviagte to user login page
		act.scrollByAmount(800, 900).perform();
		Thread.sleep(2);
		// act.moveToElement(pusp.getLoginLink()).click();
		driver.findElement(By.xpath("//a[@href='user-login.php']")).click();
// 6. login as user
		pulp.loginToPatientPanel(PU_Email, PU_Password);
		System.out.println("Patient_user login done");
// 7. book appointment
		Patient_UserDashboardPage pudbp = new Patient_UserDashboardPage(driver);
		pudbp.getBookAppointmentBtn().click();
		BookAppointmentPage bap = new BookAppointmentPage(driver);
		Thread.sleep(3);
		bap.getDoctorspecializationDD().click();
		Thread.sleep(3);
		sel.selectByVisibleText("opthalmologist");
		act.moveToElement(bap.getDoctorDD()).click().perform();
		Thread.sleep(2);
		sel.selectByIndex(01);
        //sel.selectByValue(DrName);
		Thread.sleep(1);
		bap.getDateEdit().click();
		String AppointmentDate = jlib.getSystemDate();
		bap.getDateEdit().sendKeys(AppointmentDate);
		Thread.sleep(3);
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); // date handling-need to learn
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); // time handling - need to learn
		bap.getSubmitButton().click();
		Thread.sleep(5);
		ale.accept();
// 8. logout as user
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		Thread.sleep(2);
// 9. login as dr.
		act.scrollByAmount(800, 900).perform();
		Thread.sleep(2);
		driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.loginToDoctorPanel(D_Email, Password);
// 10. go to patients> add patient
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getPatientsButton().click();
		Thread.sleep(2);
		ddp.getAddPatientButton().click();
// 11. add a patient
		String PU_Contact = elib.getDataFromExcel("Patient", 1, 1);
		String PU_Address = elib.getDataFromExcel("Patient", 1, 3);
		String PU_Age = elib.getDataFromExcel("Patient", 1, 4);
		String PU_History = elib.getDataFromExcel("Patient", 1, 5);
		AddPatientPage app = new AddPatientPage(driver);
		app.getPatientNameEdit().sendKeys(FullName);
		app.getPatientContactEdit().sendKeys(PU_Contact);
		app.getPatientEmailEdit().sendKeys(PU_Email);
		app.getMaleRadioButton().click();
		app.getPatientAddressEdit().sendKeys(PU_Address);
		app.getPatientAgeEdit().sendKeys(PU_Age);
		app.getMedicalHistoryEdit().sendKeys(PU_History);
		app.getAddButton().click();
// 12. go to patients> manage patient>eye button
		app.getPatientsButton().click();
		Thread.sleep(2);
		app.getManagePatientButton().click();
		driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		driver.findElement(By.xpath("//button[text()='Add Medical History']")).click();
		// 13. Add medical history
		AddMedicalHistoryPage amhp = new AddMedicalHistoryPage(driver);
		String BP = elib.getDataFromExcel("Patient", 1, 6);
		String Sugar = elib.getDataFromExcel("Patient", 1, 7);
		String Weight = elib.getDataFromExcel("Patient", 1, 8);
		String Temp = elib.getDataFromExcel("Patient", 1, 9);
		String Prescription = elib.getDataFromExcel("Patient", 1, 10);
		amhp.getBloodPressureEdit().sendKeys(BP);
		amhp.getBloodSugarEdit().sendKeys(Sugar);
		amhp.getWeightEdit().sendKeys(Weight);
		amhp.getBodyTempratureEdit().sendKeys(Temp); // in webpage its showing as blood sugar
		amhp.getPrescriptionEdit().sendKeys(Prescription);
		amhp.getSubmitButton().click(); // blocker - blank page coming, not able to add medical history
		// 14. logout as dr
		driver.findElement(By.xpath("//span[@class='username']")).click();
		Thread.sleep(2);
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		// 15. login as user
		act.scrollByAmount(800, 900).perform();
		Thread.sleep(2);
		driver.findElement(By.xpath("//a[@href='user-login.php']")).click();
		pulp.loginToPatientPanel(PU_Email, PU_Password);
		System.out.println("Patient_user login done");
		// 16. medical history>eye btn
		pudbp.getMedicalHistoryButton().click();
		driver.findElement(By.xpath("//a[@href='view-medhistory.php?viewid=185']")).click();
		// 17. logout as user
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("8.....System TC....-AddMedicalHistory_ST_Test===> Passed");

	}
	
}
