package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	WebDriver driver;

	public AdminDashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "username")
	private WebElement AdminLookupImg;

	@FindBy(partialLinkText = "Change Password")
	private WebElement ChangePasswordButton;

	@FindBy(partialLinkText = "Log Out")
	private WebElement LogOutButton;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement DashboardButton;

	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement DoctorsButton;

	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement DoctorSpecializationButton;

	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement AddDoctorButton;

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement ManageDoctorButton;

	@FindBy(xpath = "//span[text()=' Users ']")
	private WebElement UsersButton;

	@FindBy(xpath = "//span[text()=' Manage Users ']")
	private WebElement ManageUsersButton;

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement PatientsButton;

	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement ManangePatientsButton;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryButton;

	@FindBy(xpath = "//span[text()=' Conatctus Queries ']")
	private WebElement ContactusQueriesButton;

	@FindBy(xpath = "//span[text()=' Unread Query ']")
	private WebElement UnreadQueryButton;

	@FindBy(xpath = "//span[text()=' Read Query ']")
	private WebElement ReadQueryButton;

	@FindBy(xpath = "//span[text()=' Doctor Session Logs ']")
	private WebElement DrSessionLogsButton;

	@FindBy(xpath = "//span[text()=' User Session Logs ']")
	private WebElement UserSessionLogsButton;

	@FindBy(partialLinkText = "Total Users")
	private WebElement TotalUsersLink;

	@FindBy(partialLinkText = "Total Doctors")
	private WebElement TotalDoctorsLink;

	@FindBy(partialLinkText = "Total Appointments")
	private WebElement TotalAppointmentsLink;

	@FindBy(partialLinkText = "Total Patients")
	private WebElement TotalPatientsLink;

	@FindBy(partialLinkText = "Total New Queries")
	private WebElement TotalNewQueriesLink;

	public WebElement getAdminLookupImg() {
		return AdminLookupImg;
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

	public WebElement getDoctorsButton() {
		return DoctorsButton;
	}

	public WebElement getDoctorSpecializationButton() {
		return DoctorSpecializationButton;
	}

	public WebElement getAddDoctorButton() {
		return AddDoctorButton;
	}

	public WebElement getManageDoctorButton() {
		return ManageDoctorButton;
	}

	public WebElement getUsersButton() {
		return UsersButton;
	}

	public WebElement getManageUsersButton() {
		return ManageUsersButton;
	}

	public WebElement getPatientsButton() {
		return PatientsButton;
	}

	public WebElement getManangePatientsButton() {
		return ManangePatientsButton;
	}

	public WebElement getAppointmentHistoryButton() {
		return AppointmentHistoryButton;
	}

	public WebElement getContactusQueriesButton() {
		return ContactusQueriesButton;
	}

	public WebElement getUnreadQueryButton() {
		return UnreadQueryButton;
	}

	public WebElement getReadQueryButton() {
		return ReadQueryButton;
	}

	public WebElement getDrSessionLogsButton() {
		return DrSessionLogsButton;
	}

	public WebElement getUserSessionLogsButton() {
		return UserSessionLogsButton;
	}

	public WebElement getTotalUsersLink() {
		return TotalUsersLink;
	}

	public WebElement getTotalDoctorsLink() {
		return TotalDoctorsLink;
	}

	public WebElement getTotalAppointmentsLink() {
		return TotalAppointmentsLink;
	}

	public WebElement getTotalPatientsLink() {
		return TotalPatientsLink;
	}

	public WebElement getTotalNewQueriesLink() {
		return TotalNewQueriesLink;
	}

	public void AdminPasswordChange() {
		AdminLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(ChangePasswordButton).click().perform();
	}

	public void AdminLogout() {
		AdminLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(LogOutButton).click().perform();
	}
}
