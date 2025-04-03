package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	WebDriver driver;

	public DoctorDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='username']")
	private WebElement DoctorLookupImg;

	@FindBy(partialLinkText = "My Profile")
	private WebElement MyProfileButton;

	@FindBy(partialLinkText = "Change Password")
	private WebElement ChangePasswordButton;

	@FindBy(partialLinkText = "Log Out")
	private WebElement LogOutButton;

	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement DashboardButton;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryButton;

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement PatientsButton;

	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement AddPatientButton;

	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement ManagePatientButton;

	@FindBy(xpath = "//span[text()=' Search ']")
	private WebElement SearchButton;

	@FindBy(partialLinkText = "Update Profile")
	private WebElement UpdateProfileLink;

	@FindBy(partialLinkText = "View Appointment History")
	private WebElement ViewAppointmentHistoryButton;

	public WebElement getDoctorLookupImg() {
		return DoctorLookupImg;
	}

	public WebElement getMyProfileButton() {
		return MyProfileButton;
	}

	public WebElement getChangePasswordButton() {
		return ChangePasswordButton;
	}

	public WebElement getLogOutButton() {
		return LogOutButton;
	}

	public WebElement getDashboardButton() {
		return DashboardButton;
	}

	public WebElement getAppointmentHistoryButton() {
		return AppointmentHistoryButton;
	}

	public WebElement getPatientsButton() {
		return PatientsButton;
	}

	public WebElement getAddPatientButton() {
		return AddPatientButton;
	}

	public WebElement getManagePatientButton() {
		return ManagePatientButton;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getUpdateProfileLink() {
		return UpdateProfileLink;
	}

	public WebElement getViewAppointmentHistoryButton() {
		return ViewAppointmentHistoryButton;
	}

	public void DoctorPasswordChange() {
		DoctorLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(ChangePasswordButton).click().perform();
	}

	public void DoctorLogout() {
		DoctorLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(LogOutButton).click().perform();
	}

}
