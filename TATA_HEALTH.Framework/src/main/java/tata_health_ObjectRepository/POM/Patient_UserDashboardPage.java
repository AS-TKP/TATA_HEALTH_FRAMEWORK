package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_UserDashboardPage {

	WebDriver driver;
	public Patient_UserDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='username']")
	private WebElement UserLookupImg;

	@FindBy(partialLinkText = "My Profile")
	private WebElement MyProfileButton;

	@FindBy(partialLinkText = "Change Password")
	private WebElement ChangePasswordButton;

	@FindBy(partialLinkText = "Log Out")
	private WebElement LogOutButton;

	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement DashboardButton;

	@FindBy(xpath = "//span[text()=' Book Appointment ']")
	private WebElement BookAppointmentButton;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryButton;

	@FindBy(xpath = "//span[text()=' Medical History ']")
	private WebElement MedicalHistoryButton;

	@FindBy(partialLinkText = "Update Profile")
	private WebElement UpdateProfileLink;

	@FindBy(partialLinkText = "View Appointment History")
	private WebElement ViewAppointmentHistoryButton;

	@FindBy(partialLinkText = "Book Appointment")
	private WebElement BookAppointmentBtn;

	public WebElement getUserLookupImg() {
		return UserLookupImg;
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

	public WebElement getBookAppointmentButton() {
		return BookAppointmentButton;
	}

	public WebElement getAppointmentHistoryButton() {
		return AppointmentHistoryButton;
	}

	public WebElement getMedicalHistoryButton() {
		return MedicalHistoryButton;
	}

	public WebElement getUpdateProfileLink() {
		return UpdateProfileLink;
	}

	public WebElement getViewAppointmentHistoryButton() {
		return ViewAppointmentHistoryButton;
	}

	public WebElement getBookAppointmentBtn() {
		return BookAppointmentBtn;
	}

	public void Patient_UserPasswordChange() {
		UserLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(ChangePasswordButton).click().perform();
	}

	public void Patient_UserLogout() {
		UserLookupImg.click();
		Actions act = new Actions(driver);
		act.moveToElement(LogOutButton).click().perform();
	}

}
